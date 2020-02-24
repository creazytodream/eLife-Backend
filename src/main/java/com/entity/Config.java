package com.entity;

public class Config {
    private String paraname;

    private String paravalue;

    public String getParaname() {
        return paraname;
    }

    public void setParaname(String paraname) {
        this.paraname = paraname == null ? null : paraname.trim();
    }

    public String getParavalue() {
        return paravalue;
    }

    public void setParavalue(String paravalue) {
        this.paravalue = paravalue == null ? null : paravalue.trim();
    }
}