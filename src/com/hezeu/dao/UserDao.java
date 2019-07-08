package com.hezeu.dao;

import java.util.List;
import com.hezeu.model.Users;

public interface UserDao {
	List<Users> selectByExample(Users users);

}
