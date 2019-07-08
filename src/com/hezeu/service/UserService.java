package com.hezeu.service;

import java.util.List;
import com.hezeu.model.Users;

public interface UserService {
	//校验用户账号密码
	boolean validateLogin(Users user);

	//用户登陆信息
	List<Users> userInfo(Users user);
}
