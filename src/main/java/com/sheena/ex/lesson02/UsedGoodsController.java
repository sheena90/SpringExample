package com.sheena.ex.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sheena.ex.lesson02.bo.UsedGoodsBO;
import com.sheena.ex.lesson02.model.UsedGoods;

@Controller
public class UsedGoodsController {
	
	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	@ResponseBody
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() {
		//used goods 테이블의 모든 테이터를 조회해서 json 형태로 화면에 보여준다
		//response(json) <- controller <-> service <-> repository(쿼리 수행)
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		
		return usedGoodsList;
		
	}

}
