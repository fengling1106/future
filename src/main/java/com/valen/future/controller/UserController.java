package com.valen.future.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.valen.future.bean.cust.User;
import com.valen.future.bean.work.WorkRecord;
import com.valen.future.service.cust.IUserService;



@Controller
@RequestMapping("/user")
public class UserController {

	private static Log log = LogFactory.getLog(WorkRecord.class);
	
	@RequestMapping("/register")
	public String register() 
	{
		return "user/register"; 
	}
	
	@Autowired
	private IUserService userService;
    
	@RequestMapping(path="/register",method=RequestMethod.POST)
	public ModelAndView regNewUser(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		ModelAndView mav = new ModelAndView();
		if(userService.regUser(user))
		{	
			mav.setViewName("user/regSuccess");
			mav.addObject("user",user);	
		}
		else
		{
			mav.setViewName("user/regFail");
			mav.addObject("user",user);				
		};
		return mav;	
	}
	
	
	@RequestMapping(path="/login",method=RequestMethod.POST)
	public ModelAndView loginUser(String userName,String userPasswd,HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		ModelAndView mav = new ModelAndView();
		try{
			User user = userService.loginUser(userName, userPasswd);
			if(null!=user){
				session.setAttribute("userName", user.getUserName());
				mav.setViewName("index");
				mav.addObject("user",user);	
			}
			else
			{
				mav.setViewName("index");
				mav.addObject("user",user);	
			}
			
		}
		catch(Exception e)
		{
			log.info(e.getMessage());
		}
	
 		
	  return mav;
	}	
}
