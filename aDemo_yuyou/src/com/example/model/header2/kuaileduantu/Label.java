package com.example.model.header2.kuaileduantu;

import com.google.gson.annotations.Expose;

public class Label {

    @Expose
    private String title;
    @Expose
    private String value;
    @Expose
    private String color;
    @Expose
    private String iconUrl;

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
     *     The value
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    public void setValue(String value) {
        this.value = value;
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

}
