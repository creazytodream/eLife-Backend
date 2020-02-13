package com.controller;

import com.alibaba.fastjson.JSON;
import com.entity.UserInfo;
import com.service.UserInfoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserInfoController {
    private static final Logger bizLogger = LoggerFactory.getLogger(UserInfoController.class);
    
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/findUserInfo", method = RequestMethod.POST)
    
    @ResponseBody
    public UserInfo findUserInfo(@RequestParam(value = "openid") String openid) {
    	UserInfo userInfo =  userInfoService.findUserInfo(openid);
    	System.out.println(JSON.toJSONString(userInfo));
        return userInfo;
    }
    
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    
    @ResponseBody
    public boolean updateUserInfo(@RequestBody UserInfo userInfo) {
    	try{
    		userInfoService.updateUserInfo(userInfo);
    		return true;
    	} catch (Exception e) {
    		System.out.println(e);
    		return false;
    	}
    }
    
    @RequestMapping(value = "/insertUserInfo", method = RequestMethod.POST)
    
    @ResponseBody
    public boolean insertUserInfo(@RequestBody UserInfo userInfo) {
    	try{
    		userInfoService.insertUserInfo(userInfo);
    		return true;
    	} catch (Exception e) {
    		System.out.println(e);
    		return false;
    	}
    }
}


