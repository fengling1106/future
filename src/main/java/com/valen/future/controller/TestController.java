package com.valen.future.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping(path="/new",method=RequestMethod.GET)
	public void testFunc(HttpServletRequest request, HttpServletResponse response)  throws NoSuchAlgorithmException, UnsupportedEncodingException{
		try{
			 response.getWriter().write("SUCCESS");	
			 response.getOutputStream();
		}
			catch (Exception e)
			{
				e.printStackTrace();
			}finally{
			//	redis.delete("User:phoneId");
			}
		 
	}
}
