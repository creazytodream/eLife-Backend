package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Config;
import com.service.ConfigService;

@RestController
public class ConfigParaController {
	private static final Logger bizLogger = LoggerFactory.getLogger(ConfigParaController.class);

	@Autowired
	private ConfigService configService;

	@RequestMapping(value = "/findParaValueByParaName", method = RequestMethod.POST)

	@ResponseBody
	public List<Config> findParaValueByParaName(String paraName) {
		bizLogger.info("findParaValueByParaName paraName = "+paraName);
		final List<Config> configlist = configService.findParaValueByParaName(paraName);
		return configlist;
	}
	
	@RequestMapping(value = "/updateOrderDueTime", method = RequestMethod.POST)

	@ResponseBody
	public int updateOrderDueTime() {
		bizLogger.info("updateOrderDueTime");
		return configService.updateOrderDueTime();
	}

}


