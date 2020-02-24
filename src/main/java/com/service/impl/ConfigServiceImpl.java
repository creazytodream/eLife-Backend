package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Config;
import com.mapper.ConfigMapper;
import com.service.ConfigService;

@Service
public class ConfigServiceImpl implements ConfigService{

	@Autowired
	private ConfigMapper configMapper;

	@Override
	public Config selectByPrimaryKey(String paraname) {
		return configMapper.selectByPrimaryKey(paraname);
	}

	@Override
	public List<Config> findAllConfig() {
		return configMapper.findAllConfig();
	}
}