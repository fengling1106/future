package com.valen.future.dao.work;

import java.util.Map;

import com.valen.future.bean.work.WorkRecord;
import com.valen.future.dao.BaseDAO;

/**
 * @author fengling
 * @create 2017-12-02
 * @Description workrecord表dao访问接口
 */
public interface IWorkRecordDAO extends BaseDAO<WorkRecord>{
	//根据用户名和日期获取当日记录
	public WorkRecord getWorkRecordByUserName(Map<String, Object> hashMap);	
}
