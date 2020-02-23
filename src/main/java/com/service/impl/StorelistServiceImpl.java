package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Storelist;
import com.mapper.StorelistMapper;
import com.service.StorelistService;

@Service
public class StorelistServiceImpl implements StorelistService {

	@Autowired
	private StorelistMapper storelistMapper;

	@Override
	public List<Storelist> findStorelist() {
		return storelistMapper.findStorelist();
	}

}