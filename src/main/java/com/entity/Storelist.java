package com.entity;

public class Storelist {
    private String storeid;

    private String storename;

    private Integer storestatus;

    private String storeinfo;

    private String storeaddr;

    private String storetel;

    private String storepic;

    private String promotionpic;

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid == null ? null : storeid.trim();
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename == null ? null : storename.trim();
    }

    public Integer getStorestatus() {
        return storestatus;
    }

    public void setStorestatus(Integer storestatus) {
        this.storestatus = storestatus;
    }

    public String getStoreinfo() {
        return storeinfo;
    }

    public void setStoreinfo(String storeinfo) {
        this.storeinfo = storeinfo == null ? null : storeinfo.trim();
    }

    public String getStoreaddr() {
        return storeaddr;
    }

    public void setStoreaddr(String storeaddr) {
        this.storeaddr = storeaddr == null ? null : storeaddr.trim();
    }

    public String getStoretel() {
        return storetel;
    }

    public void setStoretel(String storetel) {
        this.storetel = storetel == null ? null : storetel.trim();
    }

    public String getStorepic() {
        return storepic;
    }

    public void setStorepic(String storepic) {
        this.storepic = storepic == null ? null : storepic.trim();
    }

    public String getPromotionpic() {
        return promotionpic;
    }

    public void setPromotionpic(String promotionpic) {
        this.promotionpic = promotionpic == null ? null : promotionpic.trim();
    }
}