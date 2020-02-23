package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.entity.Storelist;
@Mapper
public interface StorelistMapper {
	int deleteByPrimaryKey(String storeid);

	int insert(Storelist record);

	int insertSelective(Storelist record);

	Storelist selectByPrimaryKey(String storeid);

	int updateByPrimaryKeySelective(Storelist record);

	int updateByPrimaryKey(Storelist record);

	public List<Storelist> findStorelist();
}