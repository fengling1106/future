package com.valen.future.service.work;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.valen.future.bean.work.WorkRecord;

public interface IWorkRecordService {
	public void addWorkRecord(WorkRecord workRecord) throws NoSuchAlgorithmException, UnsupportedEncodingException;
	
	public WorkRecord getWorkRecordByUserNameAndDate(String userName, String strDate) throws NoSuchAlgorithmException, UnsupportedEncodingException;
}
