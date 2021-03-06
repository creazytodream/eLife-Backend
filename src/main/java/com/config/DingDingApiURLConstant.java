package com.config;

public class DingDingApiURLConstant {
    /**
     * 钉钉网关gettoken地址
     */
    public static final String URL_GET_TOKKEN = "https://oapi.dingtalk.com/gettoken";

    /**
     *获取用户在企业内userId的接口URL
     */
    public static final String URL_GET_USER_INFO = "https://oapi.dingtalk.com/user/getuserinfo";

    /**
     *获取用户姓名的接口url
     */
    public static final String URL_USER_GET = "https://oapi.dingtalk.com/user/get";
    
    public static final String URL_DEPARTMENT_LIST = "https://oapi.dingtalk.com/department/list";
    
    public static final String URL_DEPARTMENT_GET = "https://oapi.dingtalk.com/department/get";
    
    public static final String URL_DEPARTMENT_GET_PARENT = "https://oapi.dingtalk.com/department/list_parent_depts_by_dept";
}
