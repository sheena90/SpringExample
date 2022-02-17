package com.sheena.ex.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheena.ex.lesson02.dao.UsedGoodsDAO;
import com.sheena.ex.lesson02.model.UsedGoods;

@Service
public class UsedGoodsBO {
	
	@Autowired
	private UsedGoodsDAO usedGoodsDAO;

	public List<UsedGoods> getUsedGoodsList() {
		
		List<UsedGoods> usedGoodsList = usedGoodsDAO.selectUsedGoodsList();
		// 전달 받은 데이터를 조작하거나 계산하는 과정을 수행
		return usedGoodsList;
	}
}
