package com.valen.future.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.valen.future.bean.yd.Option;
import com.valen.future.service.yd.IOptionService;

@Controller
@RequestMapping("/option")
public class NoteController {
	
	@Autowired
	IOptionService optSvr;
	
	@RequestMapping(path="/addoption",method=RequestMethod.POST)
	public ModelAndView addOption(Option opt) 
	{
		ModelAndView mav = new ModelAndView();
		if (opt != null)
		{
			try
			{
				optSvr.AddOption(opt) ;
				mav.addObject("msg", "提交成功");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				mav.addObject("msg", "提交失败");
			}
			mav.setViewName("opt/option");
			return mav;
			
		}
		else
		{
			mav.setViewName("opt/option");
			mav.addObject("msg", "提交失败");
			return mav;
		}
		
	}
}
