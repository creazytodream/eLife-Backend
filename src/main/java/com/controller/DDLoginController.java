package com.controller;

import com.alibaba.fastjson.JSON;
import com.config.DingDingApiURLConstant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiDepartmentGetRequest;
import com.dingtalk.api.request.OapiDepartmentListParentDeptsByDeptRequest;
import com.dingtalk.api.request.OapiDepartmentListRequest;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiDepartmentGetResponse;
import com.dingtalk.api.response.OapiDepartmentListParentDeptsByDeptResponse;
import com.dingtalk.api.response.OapiDepartmentListResponse;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.taobao.api.ApiException;
import com.util.AccessTokenUtil;
import com.util.ServiceResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * 企业内部E应用Quick-Start示例代码 实现了最简单的免密登录（免登）功能
 */
@RestController
public class DDLoginController {
    private static final Logger bizLogger = LoggerFactory.getLogger(DDLoginController.class);

    /**
     * 钉钉用户登录，显示当前登录用户的userId和名称
     *
     * @param requestAuthCode 免登临时code
     */
    @RequestMapping(value = "/ddlogin", method = RequestMethod.POST)
    
    @ResponseBody
    public ServiceResult ddlogin(@RequestParam(value = "authCode") String authCode) {
    	bizLogger.info("ddlogin authCode = "+authCode);
    	
        //获取accessToken,注意正是代码要有异常流处理
        String accessToken = AccessTokenUtil.getToken();

        //获取用户信息
        DingTalkClient client = new DefaultDingTalkClient(DingDingApiURLConstant.URL_GET_USER_INFO);
        OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
        request.setCode(authCode);
        request.setHttpMethod("GET");

        OapiUserGetuserinfoResponse response;
        try {
            response = client.execute(request, accessToken);
            
            bizLogger.info("ddlogin response = "+JSON.toJSONString(response.getBody()));
            if (response.getErrcode() != 0) {
            	return null;
            }
        } catch (ApiException e) {
            e.printStackTrace();
            
            bizLogger.error("ddlogin URL_GET_USER_INFO api exception", e);
            return null;
        }
        //3.查询得到当前用户的userId
        // 获得到userId之后应用应该处理应用自身的登录会话管理（session）,避免后续的业务交互（前端到应用服务端）每次都要重新获取用户身份，提升用户体验
        String userId = response.getUserid();

        OapiUserGetResponse userInfo = getUserInfo(accessToken, userId);
        
        //OapiDepartmentListResponse department = getDepartment(accessToken, userInfo.getDepartment().get(0).toString());
        
        boolean hasSection = true;
        String department = "";
        String section = "";      
        
        for (int i=0; i< userInfo.getDepartment().size(); i++) {
        	OapiDepartmentListParentDeptsByDeptResponse parentDepartment = getParentDepartment(accessToken, userInfo.getDepartment().get(0).toString());
        	
        	if (parentDepartment.getParentIds().size() == 2) {
        		hasSection = false;
        	}
        	
        	String departmentId = parentDepartment.getParentIds().get(parentDepartment.getParentIds().size()-2).toString();
        	
        	OapiDepartmentGetResponse subDepartment = getSubDepartment(accessToken, departmentId);
        	
        	department = department + "," + subDepartment.getName();
        }
        
        department = department.substring(1,department.length());
        
        if(hasSection) {	        
	        for (int i=0; i< userInfo.getDepartment().size(); i++) {
	        	OapiDepartmentGetResponse subDepartment = getSubDepartment(accessToken, userInfo.getDepartment().get(i).toString());
	        	
	        	section = section + "," + subDepartment.getName();
	        }
	        
	        section = section.substring(1,section.length());
        } else {
        	section = department;
        }
        
        //返回结果
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("openid", userInfo.getOpenId());
        resultMap.put("name", userInfo.getName());
        //resultMap.put("mobile", userInfo.getMobile());   
        //resultMap.put("staffid", userInfo.getJobnumber());
        resultMap.put("department", department);
        resultMap.put("section", section);
        ServiceResult serviceResult = ServiceResult.success(resultMap);
        
        //for(Map.Entry<String, Object> entry : resultMap.entrySet()){
        //    bizLogger.info(entry.getKey()+":"+entry.getValue());
        //}
        
        return serviceResult;
    }

    /**
     * 获取用户姓名
     *
     * @param accessToken
     * @param userId
     * @return
     */
    private OapiUserGetResponse getUserInfo(String accessToken, String userId) {
    	bizLogger.info("getUserInfo userId = "+userId);
        try {
            DingTalkClient client = new DefaultDingTalkClient(DingDingApiURLConstant.URL_USER_GET);
            OapiUserGetRequest request = new OapiUserGetRequest();
            request.setUserid(userId);
            request.setHttpMethod("GET");
            OapiUserGetResponse response = client.execute(request, accessToken);
            System.out.println(JSON.toJSONString(response.getBody()));
            return response;
        } catch (ApiException e) {
            e.printStackTrace();
            
            bizLogger.error("ddlogin URL_USER_GET api exception", e);
            return null;
        }
    }
    
    private OapiDepartmentListResponse getDepartment(String accessToken, String departmentId) {
    	bizLogger.info("getDepartment departmentId = "+departmentId);
        try {
        	DingTalkClient client = new DefaultDingTalkClient(DingDingApiURLConstant.URL_DEPARTMENT_LIST);
        	OapiDepartmentListRequest request = new OapiDepartmentListRequest();
        	request.setId(departmentId);
        	request.setHttpMethod("GET");
        	OapiDepartmentListResponse response = client.execute(request, accessToken);
        	System.out.println(JSON.toJSONString(response.getBody()));
            return response;
        } catch (ApiException e) {
            e.printStackTrace();
            
            bizLogger.error("ddlogin URL_DEPARTMENT_LIST api exception", e);
            return null;
        }
    }
 
    
    private OapiDepartmentGetResponse getSubDepartment(String accessToken, String departmentId) {
    	bizLogger.info("getSubDepartment departmentId = "+departmentId);
        try {
        	DingTalkClient client = new DefaultDingTalkClient(DingDingApiURLConstant.URL_DEPARTMENT_GET);
        	OapiDepartmentGetRequest request = new OapiDepartmentGetRequest();
        	request.setId(departmentId);
        	request.setHttpMethod("GET");
        	OapiDepartmentGetResponse response = client.execute(request, accessToken);
        	System.out.println(JSON.toJSONString(response.getBody()));
            return response;
        } catch (ApiException e) {
            e.printStackTrace();
            
            bizLogger.error("ddlogin URL_DEPARTMENT_GET api exception", e);
            return null;
        }
    }
    
    private OapiDepartmentListParentDeptsByDeptResponse getParentDepartment(String accessToken, String departmentId) {
    	bizLogger.info("getParentDepartment departmentId = "+departmentId);
        try {
        	DingTalkClient client = new DefaultDingTalkClient(DingDingApiURLConstant.URL_DEPARTMENT_GET_PARENT);
        	OapiDepartmentListParentDeptsByDeptRequest request = new OapiDepartmentListParentDeptsByDeptRequest();
        	request.setId(departmentId);
        	request.setHttpMethod("GET");
        	OapiDepartmentListParentDeptsByDeptResponse response = client.execute(request, accessToken);
        	System.out.println(JSON.toJSONString(response.getBody()));
            return response;
        } catch (ApiException e) {
            e.printStackTrace();
            
            bizLogger.error("ddlogin URL_DEPARTMENT_GET_PARENT api exception", e);
            return null;
        }
    }
}


