package com.sheena.ex.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sheena.ex.lesson04.bo.UserBO;

@Controller
@RequestMapping("/lesson06")
public class Lesson06Controller {
	
	@Autowired
	private UserBO userBO;

	@GetMapping("/user_input")
	public String userInput() {
		return "lesson06/userInput";
	}
	
	@PostMapping("/add_user")
	@ResponseBody
	public String  addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("introduce") String introduce,
			@RequestParam("email") String email) {
		
		int count = userBO.addUser(name, yyyymmdd, introduce, email);
		
		if(count == 1) {
			return "success";
		} else {
			return "fail";
		}
		
	}
	
	
	// 이름 중복 확인 API
	@GetMapping("/is_duplicate")
	@ResponseBody
	public Map<String, Boolean> isDuplicate(@RequestParam("name") String name) {
		boolean isDuplicate = userBO.isDuplicate(name);
		
		// 중복인 경우
		// {"is_duplicate":true}
		
		// 중복이 아닌 경우
		// {"is_duplicate":false}
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
		// 방법1: 하지만 개발자들은 잘 안씀
//		if(isDuplicate) {
//			resultMap.put("is_duplicate", true);
//		} else {
//			resultMap.put("is_duplicate", false);
//		}
		
//		return resultMap;		
		
		// 방법2:
		resultMap.put("is_duplicate", isDuplicate);
		
		return resultMap;
	}
}
