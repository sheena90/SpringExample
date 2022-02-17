package com.sheena.ex.lesson01;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sheena.ex.lesson01.model.Person;

@RestController // @Controller + @ResponseBody
@RequestMapping("/lesson01/ex01")
public class Ex01RestController {

	@RequestMapping("/3")
	public String printString() {
		return "@RestController 테스트";
	}
	
	
	// 우리가 만든 클래스로 객체 리턴
	@RequestMapping("/4")
	public Person printPerson() {
		Person person = new Person();
		person.setName("김은숙");
		person.setAge(30);
		
		return person;
	}
	
	
	@RequestMapping("/5")
	public ResponseEntity<Person> entity() {
		Person person = new Person();
		person.setName("김은숙");
		person.setAge(30);
		
		ResponseEntity<Person> entity = new ResponseEntity(person, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
	
	 
}
