package com.sheena.ex.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sheena.ex.lesson03.model.Review;

@Repository
public interface ReviewDAO {

	//id 값을 전달 받아서 해당하는 리뷰 값을 리턴한다
	public Review selectReview(@Param("id") int id); //여기서 int id는 변수명임
	
	
	
	// 예제2 
	// 방법1:
	public int insertReviewByObject(Review review);
		
	
	// 방법2:(추천)
	public int insertReviewByField(
			@Param("storeId")int storeId,
			@Param("menu") String menu,
			@Param("userName") String userName,
			@Param("point") double point,
			@Param("review") String review
			);
}
