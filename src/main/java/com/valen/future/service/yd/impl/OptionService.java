package com.valen.future.service.yd.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valen.future.bean.yd.Option;
import com.valen.future.dao.yd.IOptionDAO;
import com.valen.future.service.yd.IOptionService;

@Service
@Transactional
public class OptionService implements IOptionService {

	@Autowired
	IOptionDAO optionDao;
	@Override
	public void AddOption(Option option) throws Exception {
		
		option.setCreateDate((new Timestamp(System.currentTimeMillis())));
		optionDao.create(option);
	}

}
