package com.valen.future.service.cust;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.valen.future.bean.cust.User;

/**
 * @author fengling
 * @create 2017-11-23
 * @Description User表service层访问接口
 */
public interface IUserService {
	
	//新用户注册
	public boolean regUser(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException	;
	
    //用户登录
	public User loginUser(String userName, String userPasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException	;
	
	//根据用户名获取用户信息
	public  User getUserByUserName(String userName);
	
	//根据用户名获取用户信息
	public  List<User> getUser();
	
}
