package com.sheena.ex.lesson05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson05")
public class Lesson05Controller {

	@GetMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		// 과일 이름 리스트
		List<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("banana");
		fruits.add("mango");
		
		model.addAttribute("paramName", fruits); // paramName은 List<String> 변수명 fruits의 이름으로 지정한 것임.
		
		return "lesson05/ex02";
	}
}
