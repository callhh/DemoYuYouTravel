package com.example.model.faxian;

import com.google.gson.annotations.Expose;

public class AreaInfo {

    @Expose
    private String browseAreaDestinationTitle;
    @Expose
    private String browseAreaDestinationIcon;
    @Expose
    private String browseAreaDestinationSubTitle;
    @Expose
    private String browseAreaDestinationUrl;

    /**
     * 
     * @return
     *     The browseAreaDestinationTitle
     */
    public String getBrowseAreaDestinationTitle() {
        return browseAreaDestinationTitle;
    }

    /**
     * 
     * @param browseAreaDestinationTitle
     *     The browseAreaDestinationTitle
     */
    public void setBrowseAreaDestinationTitle(String browseAreaDestinationTitle) {
        this.browseAreaDestinationTitle = browseAreaDestinationTitle;
    }

    /**
     * 
     * @return
     *     The browseAreaDestinationIcon
     */
    public String getBrowseAreaDestinationIcon() {
        return browseAreaDestinationIcon;
    }

    /**
     * 
     * @param browseAreaDestinationIcon
     *     The browseAreaDestinationIcon
     */
    public void setBrowseAreaDestinationIcon(String browseAreaDestinationIcon) {
        this.browseAreaDestinationIcon = browseAreaDestinationIcon;
    }

    /**
     * 
     * @return
     *     The browseAreaDestinationSubTitle
     */
    public String getBrowseAreaDestinationSubTitle() {
        return browseAreaDestinationSubTitle;
    }

    /**
     * 
     * @param browseAreaDestinationSubTitle
     *     The browseAreaDestinationSubTitle
     */
    public void setBrowseAreaDestinationSubTitle(String browseAreaDestinationSubTitle) {
        this.browseAreaDestinationSubTitle = browseAreaDestinationSubTitle;
    }

    /**
     * 
     * @return
     *     The browseAreaDestinationUrl
     */
    public String getBrowseAreaDestinationUrl() {
        return browseAreaDestinationUrl;
    }

    /**
     * 
     * @param browseAreaDestinationUrl
     *     The browseAreaDestinationUrl
     */
    public void setBrowseAreaDestinationUrl(String browseAreaDestinationUrl) {
        this.browseAreaDestinationUrl = browseAreaDestinationUrl;
    }

}
