package com.example.model.faxian;

import com.google.gson.annotations.Expose;

public class ModuleContentList {

    @Expose
    private String amount;
    @Expose
    private String orgAmount;
    @Expose
    private String jumpUrl;
    @Expose
    private String title;
    @Expose
    private String subTitle;
    @Expose
    private String picUrl;
    @Expose
    private String bigpicUrl;
    @Expose
    private String productTag;
    @Expose
    private String productId;
    @Expose
    private String resourceId;

    /**
     * 
     * @return
     *     The amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * 
     * @param amount
     *     The amount
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * 
     * @return
     *     The orgAmount
     */
    public String getOrgAmount() {
        return orgAmount;
    }

    /**
     * 
     * @param orgAmount
     *     The orgAmount
     */
    public void setOrgAmount(String orgAmount) {
        this.orgAmount = orgAmount;
    }

    /**
     * 
     * @return
     *     The jumpUrl
     */
    public String getJumpUrl() {
        return jumpUrl;
    }

    /**
     * 
     * @param jumpUrl
     *     The jumpUrl
     */
    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The subTitle
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * 
     * @param subTitle
     *     The subTitle
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     * 
     * @return
     *     The picUrl
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 
     * @param picUrl
     *     The picUrl
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * 
     * @return
     *     The bigpicUrl
     */
    public String getBigpicUrl() {
        return bigpicUrl;
    }

    /**
     * 
     * @param bigpicUrl
     *     The bigpicUrl
     */
    public void setBigpicUrl(String bigpicUrl) {
        this.bigpicUrl = bigpicUrl;
    }

    /**
     * 
     * @return
     *     The productTag
     */
    public String getProductTag() {
        return productTag;
    }

    /**
     * 
     * @param productTag
     *     The productTag
     */
    public void setProductTag(String productTag) {
        this.productTag = productTag;
    }

    /**
     * 
     * @return
     *     The productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId
     *     The productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 
     * @return
     *     The resourceId
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * 
     * @param resourceId
     *     The resourceId
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

}
