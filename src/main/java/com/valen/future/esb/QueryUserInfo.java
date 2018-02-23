package com.valen.future.esb;

import java.io.BufferedInputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valen.future.bean.cust.User;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/query")
public class QueryUserInfo {
	
	@RequestMapping(path="/UserInfo",method=RequestMethod.POST)
	public @ResponseBody User QueryUserInfoByName(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		 StringBuffer str = new StringBuffer();   
	        try {  
	               BufferedInputStream in = new BufferedInputStream(request.getInputStream());  
	                  int i;  
	                  char c;  
	                  while ((i=in.read())!=-1) {  
	                  c=(char)i;  
	                  str.append(c);  
	                  }  
	                 }catch (Exception ex) {  
	               ex.printStackTrace();  
	               }  
	        JSONObject obj= JSONObject.fromObject(str.toString());  
	        System.out.println(obj.get("name"));  
		
        User user = new User();
        user.setUserName("fengling");
        user.setEmail("123333");
        return user;
	}

	
	@RequestMapping(path="/UserInfo",method=RequestMethod.GET)
	public @ResponseBody User QueryUserInfoByName2(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		 StringBuffer str = new StringBuffer();   
	      str = str.append(request.getQueryString());  
	      System.out.println(str);  
	     Map<String, String[]> map  = request.getParameterMap();
			String queryString = "";
			for (String key : map.keySet()) {
				String[] values = map.get(key);
				for (int i = 0; i < values.length; i++) {
					String value = values[i];
					System.out.println(value);
					queryString += key + "=" + value + "&";
				}
			}
	     
        User user = new User();
        user.setUserName("fengling");
        user.setEmail("888888");
        return user;
	}	
}
