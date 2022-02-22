package com.sheena.ex.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheena.ex.lesson04.dao.UserDAO;
import com.sheena.ex.lesson04.model.UserModel;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;

	public UserModel getLastUser() {
		return userDAO.selectLastUser();
	}
	
	
	
	// INSERT
	public int addUser(String name, String yyyymmdd, String introduce, String email) {
		return userDAO.insertUser(name, yyyymmdd, introduce, email);
	}
}
