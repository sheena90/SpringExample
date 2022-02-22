package com.sheena.ex.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sheena.ex.lesson03.bo.ReviewBO;
import com.sheena.ex.lesson03.model.Review;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewBO reviewBO;

	@ResponseBody
	@RequestMapping("/lesson03/ex01")
	public Review review(
//			@RequestParam("id") int id) { // 기본 사용법 필수 파라미터
//			@RequestParam(value="id", required=true) int id) { // 필수 파라미터
//			@RequestParam(value="id", required=false) Integer id) { // 비 필수 파라미터
			@RequestParam(value="id", defaultValue="1") int id) {

		
//		if(id == null) { //비 필수 파라미터랑 세트
//			id = 1;
//		}
			
		return reviewBO.getReview(id);

	}
	
	
	
	
	// 예제2 INSERT 다루기
	// 방법1:
	@ResponseBody
	@RequestMapping("/lesson03/ex02")
	public String ex02() {
		// 객체 형태로 파라미터 활용하기
//		Review review = new Review();
//		review.setStoreId(2);
//		review.setMenu("뿌링클");
//		review.setUserName("김인규");
//		review.setPoint(4.0);
//		review.setReview("역시 뿌링클은 진리 입니다.");
//		
//		int count = reviewBO.addReviewByObject(review);
//		
//		return "삽입 결과 : " + count;
		
		
	// 방법2:(추천)
		int count = reviewBO.addReviewByField(4, "콤비네이션피자", "김바다", 4.5, "할인도 많이 받고 잘 먹었어요.");
		
		return "삽입 결과 : " + count;
		
	}
}
