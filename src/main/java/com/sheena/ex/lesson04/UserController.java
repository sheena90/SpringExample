package com.sheena.ex.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sheena.ex.lesson04.bo.UserBO;
import com.sheena.ex.lesson04.model.UserModel;

@RequestMapping("/lesson04")
@Controller
public class UserController {

	@Autowired
	private UserBO userBO;
	
	@RequestMapping("/ex01")
	public String getUserView(Model model) {
		// 가장 최근 추가된 사용자 정보
		UserModel user = userBO.getLastUser();
		
		model.addAttribute("result", user);
		
		return "lesson04/ex01";
	}
	
	
	
	// input
	@RequestMapping("/ex01/input")
	public String addView() {
		return "lesson04/ex01_insert";
	}
	
	
	
	// INSERT
	@ResponseBody
	@RequestMapping("/ex01/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("introduce") String introduce,
			@RequestParam("email") String email) {
		
		// 이름, 생년월일, 자기소개, 이메일 주소
		int count = userBO.addUser(name, yyyymmdd, introduce, email);
		
		return "입력 성공 : " + count;
		
		
		
		
		
		
	}
}
