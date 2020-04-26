package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Goodslist;
import com.entity.Storelist;
import com.service.GoodslistService;
import com.service.StorelistService;

@RestController
public class GoodsListController {
	private static final Logger bizLogger = LoggerFactory.getLogger(GoodsListController.class);

	@Autowired
	private GoodslistService goodslistService;

	@RequestMapping(value = "/findGoodslistByStoreId", method = RequestMethod.POST)

	@ResponseBody
	public List<Goodslist> findGoodslistByStoreId(String storeId) {
		bizLogger.info("findGoodslistByStoreId storeId = "+storeId);
		final List<Goodslist> storelist = goodslistService.findGoodslistByStoreId(storeId);
		//System.out.println(JSON.toJSONString(userInfo));
		return storelist;
	}
	
	@RequestMapping(value = "/findOrderedGoodslistByUserId", method = RequestMethod.POST)

	@ResponseBody
	public List<Goodslist> findOrderedGoodslistByUserId(String openid) {
		bizLogger.info("findOrderedGoodslistByUserId openid = "+openid);
		final List<Goodslist> goodslist = goodslistService.findOrderedGoodslistByUserId(openid);
		return goodslist;
	}

}


