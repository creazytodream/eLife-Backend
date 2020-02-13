package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.UserInfo;
import com.mapper.UserInfoMapper;
import com.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	@Autowired
    private UserInfoMapper userInfoMapper;
    
    @Override
    public void insertUserInfo(UserInfo userInfo) {
    	userInfoMapper.insertUserInfo(userInfo);
    }
    
    @Override
    public void updateUserInfo(UserInfo userInfo) {
    	userInfoMapper.updateUserInfo(userInfo);
    }

    @Override
    public UserInfo findUserInfo(String openid) {
    	return userInfoMapper.findUserInfo(openid);
    }
  
    @Override
    public void deleteUserInfo(int id) {
    	userInfoMapper.deleteUserInfo(id);
    }
}