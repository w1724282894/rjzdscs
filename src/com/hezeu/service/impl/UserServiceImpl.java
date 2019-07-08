package com.hezeu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hezeu.dao.UserDao;
import com.hezeu.model.Users;
import com.hezeu.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public boolean validateLogin( Users user ) {
		List<Users> adminList = this.userDao.selectByExample(user);
		System.out.println(adminList);
		System.out.println(!adminList.isEmpty());
		if(!adminList.isEmpty()){
			//该账户为管理员账户
			return true;
		}else{
			return false;
		}
	}
	@Override
	public List<Users> userInfo( Users user ) {
		// TODO Auto-generated method stub
		return null;
	}
}
