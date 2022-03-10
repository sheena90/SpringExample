package com.sheena.ex.lesson04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sheena.ex.lesson04.model.UserModel;

@Repository
public interface UserDAO {
	
	public UserModel selectLastUser();
	
	
	// INSERT
	public int insertUser(
			@Param("name") String name,
			@Param("yyyymmdd") String yyyymmdd,
			@Param("introduce") String introduce,
			@Param("email") String email);

	
	// lesson06의 중복확인
	public int selectNameCount(@Param("name") String name);
}
