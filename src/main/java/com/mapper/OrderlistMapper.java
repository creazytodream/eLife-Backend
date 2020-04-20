package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.entity.Orderlist;

@Mapper
public interface OrderlistMapper {
    int deleteByPrimaryKey(String orderid);

	int insert(Orderlist record);

	int insertSelective(Orderlist record);

	Orderlist selectByPrimaryKey(String orderid);

	int updateByPrimaryKeySelective(Orderlist record);

	int updateByPrimaryKey(Orderlist record);
	
	public List<Orderlist> findOrderlist(String openid, String orderstatus);
}