package com.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Goodslist {
    private String productid;

    private String productname;

    private BigDecimal productprice;

    private Integer productstock;

    private String productdesc;

    private Integer productstatus;

    private Integer categorytype;

    private String producticon;

    private String storeid;

    private String goodsdate;

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public BigDecimal getProductprice() {
        return productprice;
    }

    public void setProductprice(BigDecimal productprice) {
        this.productprice = productprice;
    }

    public Integer getProductstock() {
        return productstock;
    }

    public void setProductstock(Integer productstock) {
        this.productstock = productstock;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc == null ? null : productdesc.trim();
    }

    public Integer getProductstatus() {
        return productstatus;
    }

    public void setProductstatus(Integer productstatus) {
        this.productstatus = productstatus;
    }

    public Integer getCategorytype() {
        return categorytype;
    }

    public void setCategorytype(Integer categorytype) {
        this.categorytype = categorytype;
    }

    public String getProducticon() {
        return producticon;
    }

    public void setProducticon(String producticon) {
        this.producticon = producticon == null ? null : producticon.trim();
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid == null ? null : storeid.trim();
    }

    public String getGoodsdate() {
        return goodsdate;
    }

    public void setGoodsdate(String goodsdate) {
        this.goodsdate = goodsdate;
    }
}