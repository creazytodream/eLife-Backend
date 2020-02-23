package com.mapper;

import java.util.List;

import com.entity.Goodslist;

public interface GoodslistMapper {
	int deleteByPrimaryKey(String productid);

	int insert(Goodslist record);

	int insertSelective(Goodslist record);

	Goodslist selectByPrimaryKey(String productid);

	int updateByPrimaryKeySelective(Goodslist record);

	int updateByPrimaryKey(Goodslist record);

	public List<Goodslist> findGoodslistByStoreId(String storeId);
}