package com.sheena.ex.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sheena.ex.lesson04.bo.StudentBO;
import com.sheena.ex.lesson04.model.StudentModel;

@Controller
@RequestMapping("/lesson04/ex02")
public class StudentController {
	
	@Autowired
	private StudentBO studentBO;
	
	@GetMapping("/input")
	public String studentInput() {
		return "lesson04/ex02Input";
	}
	
	@GetMapping("/add_student")
	public String addStudent(@ModelAttribute StudentModel student, Model model) {
		
		int count = studentBO.addStudent(student);
		
		model.addAttribute("result", student);
		
		return "lesson04/ex02Info";
	}

}
