package com.example.model.header2;

import com.google.gson.annotations.Expose;

public class MainMenuList {

    @Expose
    private String isSelected;
    @Expose
    private String activeIconUrl;
    @Expose
    private String iconUrl;
    @Expose
    private String color;
    @Expose
    private String menuId;
    @Expose
    private String title;
    @Expose
    private String subTitle;
    @Expose
    private EventTag eventTag;

    /**
     * 
     * @return
     *     The isSelected
     */
    public String getIsSelected() {
        return isSelected;
    }

    /**
     * 
     * @param isSelected
     *     The isSelected
     */
    public void setIsSelected(String isSelected) {
        this.isSelected = isSelected;
    }

    /**
     * 
     * @return
     *     The activeIconUrl
     */
    public String getActiveIconUrl() {
        return activeIconUrl;
    }

    /**
     * 
     * @param activeIconUrl
     *     The activeIconUrl
     */
    public void setActiveIconUrl(String activeIconUrl) {
        this.activeIconUrl = activeIconUrl;
    }

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
     *     The menuId
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * 
     * @param menuId
     *     The menuId
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
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
     *     The eventTag
     */
    public EventTag getEventTag() {
        return eventTag;
    }

    /**
     * 
     * @param eventTag
     *     The eventTag
     */
    public void setEventTag(EventTag eventTag) {
        this.eventTag = eventTag;
    }

}
