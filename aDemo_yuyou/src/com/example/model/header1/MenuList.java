package com.example.model.header1;

import com.google.gson.annotations.Expose;

public class MenuList {

    @Expose
    private String iconUrl;
    @Expose
    private String iconActiveUrl;
    @Expose
    private String url;
    @Expose
    private String title;
    @Expose
    private String markId;
    @Expose
    private String markType;
    @Expose
    private String markIcon;
    @Expose
    private String tag;
    @Expose
    private String type;
    @Expose
    private String subType;
    @Expose
    private String sortNo;
    @Expose
    private EventTag_ eventTag;

    /**
     * 
     * @return
     *     The iconUrl
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * 
     * @param iconUrl
     *     The iconUrl
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * 
     * @return
     *     The iconActiveUrl
     */
    public String getIconActiveUrl() {
        return iconActiveUrl;
    }

    /**
     * 
     * @param iconActiveUrl
     *     The iconActiveUrl
     */
    public void setIconActiveUrl(String iconActiveUrl) {
        this.iconActiveUrl = iconActiveUrl;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
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
     *     The markType
     */
    public String getMarkType() {
        return markType;
    }

    /**
     * 
     * @param markType
     *     The markType
     */
    public void setMarkType(String markType) {
        this.markType = markType;
    }

    /**
     * 
     * @return
     *     The markIcon
     */
    public String getMarkIcon() {
        return markIcon;
    }

    /**
     * 
     * @param markIcon
     *     The markIcon
     */
    public void setMarkIcon(String markIcon) {
        this.markIcon = markIcon;
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

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The subType
     */
    public String getSubType() {
        return subType;
    }

    /**
     * 
     * @param subType
     *     The subType
     */
    public void setSubType(String subType) {
        this.subType = subType;
    }

    /**
     * 
     * @return
     *     The sortNo
     */
    public String getSortNo() {
        return sortNo;
    }

    /**
     * 
     * @param sortNo
     *     The sortNo
     */
    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * 
     * @return
     *     The eventTag
     */
    public EventTag_ getEventTag() {
        return eventTag;
    }

    /**
     * 
     * @param eventTag
     *     The eventTag
     */
    public void setEventTag(EventTag_ eventTag) {
        this.eventTag = eventTag;
    }

}
