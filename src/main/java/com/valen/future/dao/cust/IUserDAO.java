package com.valen.future.dao.cust;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.valen.future.bean.cust.User;
import com.valen.future.dao.BaseDAO;

/**
 * @author fengling
 * @create 2017-11-23
 * @Description User表dao访问接口
 */

@Repository
public interface IUserDAO extends BaseDAO<User> {
	

	//根据用户名获取用户信息
	public User getUserByUserName(Map<String, Object> hashMap);	

	//根据用户名和密码检查
	public User checkUserByNameAndPwd(Map<String, Object> hashMap);	
}
