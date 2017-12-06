package com.valen.future.service.cust.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valen.future.bean.cust.User;
import com.valen.future.bean.work.WorkRecord;
import com.valen.future.dao.cust.IUserDAO;
import com.valen.future.service.cust.IUserService;


@Service
@Transactional
public class UserService implements IUserService {
   	
	private static Log log = LogFactory.getLog(WorkRecord.class);
	
	@Autowired
	IUserDAO userDao ; 
	
	public boolean regUser(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		//检查用户名是否唯一
		
		//检查邮箱是否唯一
		
		//注册新用户
		user.setState(2);//设置用户为待邮件确认状态
		user.setCreateDate(new Timestamp(System.currentTimeMillis()));
		user.setModifyDate(user.getCreateDate());
		userDao.create(user);
		return true;
    }
	
	public User loginUser(String userName, String userPasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException	
	{
		try{
	    	Map<String, Object> map=new HashMap<String, Object>();
			map.put("userName", "\'"+userName+"\'");
			map.put("userPasswd", "\'"+userPasswd+"\'");	
			
			User user=userDao.checkUserByNameAndPwd(map);
			
			if(null != user && 1==user.getState())
			{
				return user;
			}
			else{
				return null;
			}
			
		}
		catch(Exception e){
			log.info(e.getMessage());
			return null;
			
		}
			
	}

	public User getUserByUserName(String userName) {
    	Map<String, Object> map=new HashMap<String, Object>();
		map.put("userName", "\'"+userName+"\'");

		return null;
	}
}
