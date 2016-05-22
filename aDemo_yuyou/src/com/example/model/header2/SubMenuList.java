package com.example.model.header2;

import com.google.gson.annotations.Expose;

public class SubMenuList {

    @Expose
    private String color;
    @Expose
    private String subMenuId;
    @Expose
    private String tag;
    @Expose
    private String title;
    @Expose
    private DefaultEvent__ defaultEvent;

    /**
     * 
     * @return
     *     The color
     */
    public String getColor() {
        return color;
    }

    /**
     * 
     * @param color
     *     The color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 
     * @return
     *     The subMenuId
     */
    public String getSubMenuId() {
        return subMenuId;
    }

    /**
     * 
     * @param subMenuId
     *     The subMenuId
     */
    public void setSubMenuId(String subMenuId) {
        this.subMenuId = subMenuId;
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
     *     The defaultEvent
     */
    public DefaultEvent__ getDefaultEvent() {
        return defaultEvent;
    }

    /**
     * 
     * @param defaultEvent
     *     The defaultEvent
     */
    public void setDefaultEvent(DefaultEvent__ defaultEvent) {
        this.defaultEvent = defaultEvent;
    }

}
