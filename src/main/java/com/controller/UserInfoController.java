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
    	bizLogger.info("findUserInfo openid = "+openid);
    	UserInfo userInfo =  userInfoService.findUserInfo(openid);
    	//System.out.println(JSON.toJSONString(userInfo));
    	
    	bizLogger.info("findUserInfo response = "+JSON.toJSONString(userInfo));
        return userInfo;
    }
    
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    
    @ResponseBody
    public boolean updateUserInfo(UserInfo userInfo) {
    	bizLogger.info("updateUserInfo openid = "+userInfo.getOpenid());
    	try{
    		//System.out.println(JSON.toJSONString(userInfo));
    		userInfoService.updateUserInfo(userInfo);
    		return true;
    	} catch (Exception e) {
    		bizLogger.error("updateUserInfo", e);
    		return false;
    	}
    }
    
    @RequestMapping(value = "/insertUserInfo", method = RequestMethod.POST)
    
    @ResponseBody
    public boolean insertUserInfo(UserInfo userInfo) {
    	bizLogger.info("insertUserInfo openid = "+userInfo.getOpenid());
    	try{
    		userInfoService.insertUserInfo(userInfo);
    		return true;
    	} catch (Exception e) {
    		bizLogger.error("insertUserInfo", e);
    		return false;
    	}
    }
}


