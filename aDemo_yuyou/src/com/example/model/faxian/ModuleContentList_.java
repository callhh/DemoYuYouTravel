package com.example.model.faxian;

import com.google.gson.annotations.Expose;

public class ModuleContentList_ {

    @Expose
    private String numberMark;
    @Expose
    private String jumpUrl;
    @Expose
    private String title;
    @Expose
    private String picUrl;
    @Expose
    private String resourceId;

    /**
     * 
     * @return
     *     The numberMark
     */
    public String getNumberMark() {
        return numberMark;
    }

    /**
     * 
     * @param numberMark
     *     The numberMark
     */
    public void setNumberMark(String numberMark) {
        this.numberMark = numberMark;
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
