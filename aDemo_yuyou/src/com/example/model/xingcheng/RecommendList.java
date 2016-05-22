package com.example.model.xingcheng;

import com.google.gson.annotations.Expose;

public class RecommendList {

    @Expose
    private String imgUrl;
    @Expose
    private String jumpUrl;
    @Expose
    private String mainTitle;
    @Expose
    private String subTitle;

    /**
     * 
     * @return
     *     The imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 
     * @param imgUrl
     *     The imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
     *     The mainTitle
     */
    public String getMainTitle() {
        return mainTitle;
    }

    /**
     * 
     * @param mainTitle
     *     The mainTitle
     */
    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
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

}
