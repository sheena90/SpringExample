package com.sheena.ex.lesson04.dao;

import org.springframework.stereotype.Repository;

import com.sheena.ex.lesson04.model.StudentModel;

@Repository
public interface StudentDAO {
	
	public int insertStudent(StudentModel student);

}
