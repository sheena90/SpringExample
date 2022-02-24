package com.sheena.ex.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheena.ex.lesson04.dao.StudentDAO;
import com.sheena.ex.lesson04.model.StudentModel;

@Service
public class StudentBO {
	
	@Autowired
	private StudentDAO studentDAO;
	
	public int addStudent(StudentModel student) {
		return studentDAO.insertStudent(student);
	}

}
