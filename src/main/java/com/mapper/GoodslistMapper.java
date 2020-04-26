package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.entity.Goodslist;
@Mapper
public interface GoodslistMapper {
	int deleteByPrimaryKey(String productid);

	int insert(Goodslist record);

	int insertSelective(Goodslist record);

	Goodslist selectByPrimaryKey(String productid);

	int updateByPrimaryKeySelective(Goodslist record);

	int updateByPrimaryKey(Goodslist record);

	public List<Goodslist> findGoodslistByStoreId(String storeId);
	
	public List<Goodslist> findOrderedGoodslistByUserId(String openid);
}