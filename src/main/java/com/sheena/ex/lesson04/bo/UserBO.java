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
	
	
	// lesson06의 중복확인
	public boolean isDuplicate(String name) {
		
		int count = userDAO.selectNameCount(name);
		
		// 방법1: 하지만 개발자들은 이렇게 잘 안씀
//		if(count == 0) {
//			return false;
//		} else {
//			return true;
//		}
		
		
		// 방법2:
//		return !(count == 0);
		return (count != 0);
	}
}
