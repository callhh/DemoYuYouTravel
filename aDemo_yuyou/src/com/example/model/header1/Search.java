package com.example.model.header1;

import com.google.gson.annotations.Expose;

public class Search {

    @Expose
    private String homeShowName;
    @Expose
    private String insideShowName;
    @Expose
    private String redirectUrl;
    @Expose
    private String tag;

    /**
     * 
     * @return
     *     The homeShowName
     */
    public String getHomeShowName() {
        return homeShowName;
    }

    /**
     * 
     * @param homeShowName
     *     The homeShowName
     */
    public void setHomeShowName(String homeShowName) {
        this.homeShowName = homeShowName;
    }

    /**
     * 
     * @return
     *     The insideShowName
     */
    public String getInsideShowName() {
        return insideShowName;
    }

    /**
     * 
     * @param insideShowName
     *     The insideShowName
     */
    public void setInsideShowName(String insideShowName) {
        this.insideShowName = insideShowName;
    }

    /**
     * 
     * @return
     *     The redirectUrl
     */
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * 
     * @param redirectUrl
     *     The redirectUrl
     */
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    /**
     * 
     * @return
     *     The tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * 
     * @param tag
     *     The tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

}
