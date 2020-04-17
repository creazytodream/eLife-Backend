package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Storelist;
import com.service.StorelistService;

@RestController
public class StoreListController {
	private static final Logger bizLogger = LoggerFactory.getLogger(StoreListController.class);

	@Autowired
	private StorelistService storelistService;

	@RequestMapping(value = "/findStorelist", method = RequestMethod.POST)

	@ResponseBody
	public List<Storelist> findStorelist() {
		bizLogger.info("findStorelist");
		final List<Storelist> storelist = storelistService.findStorelist();
		//System.out.println(JSON.toJSONString(userInfo));
		return storelist;
	}

}


