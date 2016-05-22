package com.example.model.faxian;

import com.google.gson.annotations.Expose;

public class ThemeList {

    @Expose
    private String resourceId;
    @Expose
    private String projectId;
    @Expose
    private String productName;
    @Expose
    private String imageUrl;
    @Expose
    private String title;
    @Expose
    private String details;
    @Expose
    private String subTitle;
    @Expose
    private String jumpUrl;

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

    /**
     * 
     * @return
     *     The projectId
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * 
     * @param projectId
     *     The projectId
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * 
     * @return
     *     The productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 
     * @param productName
     *     The productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 
     * @return
     *     The imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 
     * @param imageUrl
     *     The imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
     *     The details
     */
    public String getDetails() {
        return details;
    }

    /**
     * 
     * @param details
     *     The details
     */
    public void setDetails(String details) {
        this.details = details;
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

}
