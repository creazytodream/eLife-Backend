package com.service;

import java.util.List;

import com.entity.Goodslist;

public interface GoodslistService {
	public List<Goodslist> findGoodslistByStoreId(String storeId);
}