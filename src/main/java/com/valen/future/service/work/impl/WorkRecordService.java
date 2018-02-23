package com.valen.future.service.work.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valen.future.bean.work.WorkRecord;
import com.valen.future.dao.work.IWorkRecordDAO;
import com.valen.future.service.work.IWorkRecordService;


@Service
@Transactional
public class WorkRecordService implements IWorkRecordService {

	@Autowired
	IWorkRecordDAO workRecordDao;
	
	private static Log log = LogFactory.getLog(WorkRecord.class);
	
	//增加新工作记录
	public void addWorkRecord(WorkRecord workRecord) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		try{
			if (workRecord != null) //如果有内容则保存
			{		
				Date currentTime = new Date();
			    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String dateString = formatter.format(currentTime);
							
				//首次插入新记录，否则更新当日记录
				if(null != getWorkRecordByUserNameAndDate(workRecord.getUserName(),dateString))
				{
					Map<String,Object> map = new HashMap<String, Object>();
					map.put("comment", workRecord.getComment());
					map.put("userName", workRecord.getUserName());
					map.put("noteDate", dateString);
					workRecord.setModifyDate((new Timestamp(System.currentTimeMillis())));
					workRecordDao.updateCommentByUserName(map);
				}
				else
				{
					workRecord.setNoteDate(dateString);
					workRecord.setState(1);	
					workRecord.setCreateDate((new Timestamp(System.currentTimeMillis())));
					workRecord.setModifyDate(workRecord.getCreateDate());
					workRecordDao.insert(workRecord);
				}						
			}
		}
		catch(Exception e){
			log.info(e.getMessage());
		}
	}

	public WorkRecord getWorkRecordByUserNameAndDate(String userName, String strDate) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		//WorkRecord workRecord = null;
		
		try{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("userName", userName);
			map.put("noteDate", strDate);
			WorkRecord workRecord=workRecordDao.getWorkRecordByUserName(map);
			return workRecord;
		}
		catch (Exception e)
		{
			log.info(e.getMessage());	
			return null;
		}
						
	}
}

