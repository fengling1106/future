package com.valen.future.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.valen.future.bean.work.WorkRecord;
import com.valen.future.service.work.IWorkRecordService;

@Controller
@RequestMapping("/work")
public class WorkController {

	@Autowired
	private IWorkRecordService workRecordService;
	
	
	@RequestMapping(path="/open",method=RequestMethod.POST)
	public ModelAndView openMain()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("work/mainWork");
		return mav;
	}
	
	@RequestMapping(path="/addrecord",method=RequestMethod.POST)
	public ModelAndView addNewWorkRecord(WorkRecord workRecord,HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ModelAndView mav = new ModelAndView();
		workRecord.setUserName(request.getSession().getAttribute("userName").toString());
		workRecordService.addWorkRecord(workRecord);
		mav.setViewName("work/mainWork");
		return mav;
	}

}
