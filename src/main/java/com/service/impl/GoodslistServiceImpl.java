package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Goodslist;
import com.mapper.GoodslistMapper;
import com.service.GoodslistService;

@Service
public class GoodslistServiceImpl implements GoodslistService {

	@Autowired
	private GoodslistMapper goodslistMapper;

	@Override
	public List<Goodslist> findGoodslistByStoreId(String storeId) {
		return goodslistMapper.findGoodslistByStoreId(storeId);
	}
	
	@Override
	public List<Goodslist> findOrderedGoodslistByUserId(String openid){
		return goodslistMapper.findOrderedGoodslistByUserId(openid);
	}
	
	@Override
	public int updateGoodslistStatus() {
		return goodslistMapper.updateGoodslistStatus();
	}

}