package com.example.model.mudidi1;

import com.google.gson.annotations.Expose;

public class AnimationShow {

    @Expose
    private String markId;
    @Expose
    private String showType;
    @Expose
    private String showIconUrl;
    @Expose
    private String showTime;
    @Expose
    private String speedType;
    @Expose
    private String isRotation;

    /**
     * 
     * @return
     *     The markId
     */
    public String getMarkId() {
        return markId;
    }

    /**
     * 
     * @param markId
     *     The markId
     */
    public void setMarkId(String markId) {
        this.markId = markId;
    }

    /**
     * 
     * @return
     *     The showType
     */
    public String getShowType() {
        return showType;
    }

    /**
     * 
     * @param showType
     *     The showType
     */
    public void setShowType(String showType) {
        this.showType = showType;
    }

    /**
     * 
     * @return
     *     The showIconUrl
     */
    public String getShowIconUrl() {
        return showIconUrl;
    }

    /**
     * 
     * @param showIconUrl
     *     The showIconUrl
     */
    public void setShowIconUrl(String showIconUrl) {
        this.showIconUrl = showIconUrl;
    }

    /**
     * 
     * @return
     *     The showTime
     */
    public String getShowTime() {
        return showTime;
    }

    /**
     * 
     * @param showTime
     *     The showTime
     */
    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    /**
     * 
     * @return
     *     The speedType
     */
    public String getSpeedType() {
        return speedType;
    }

    /**
     * 
     * @param speedType
     *     The speedType
     */
    public void setSpeedType(String speedType) {
        this.speedType = speedType;
    }

    /**
     * 
     * @return
     *     The isRotation
     */
    public String getIsRotation() {
        return isRotation;
    }

    /**
     * 
     * @param isRotation
     *     The isRotation
     */
    public void setIsRotation(String isRotation) {
        this.isRotation = isRotation;
    }

}
