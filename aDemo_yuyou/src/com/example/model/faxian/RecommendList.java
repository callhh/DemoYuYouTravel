package com.example.model.faxian;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class RecommendList {

    @Expose
    private String moduleIcon;
    @Expose
    private String moduleListUrl;
    @Expose
    private String moduleTitle;
    @Expose
    private String moduleGuideType;
    @Expose
    private String moduleGuideContent;
    @Expose
    private String isHot;
    @Expose
    private List<ModuleContentList> moduleContentList = new ArrayList<ModuleContentList>();

    /**
     * 
     * @return
     *     The moduleIcon
     */
    public String getModuleIcon() {
        return moduleIcon;
    }

    /**
     * 
     * @param moduleIcon
     *     The moduleIcon
     */
    public void setModuleIcon(String moduleIcon) {
        this.moduleIcon = moduleIcon;
    }

    /**
     * 
     * @return
     *     The moduleListUrl
     */
    public String getModuleListUrl() {
        return moduleListUrl;
    }

    /**
     * 
     * @param moduleListUrl
     *     The moduleListUrl
     */
    public void setModuleListUrl(String moduleListUrl) {
        this.moduleListUrl = moduleListUrl;
    }

    /**
     * 
     * @return
     *     The moduleTitle
     */
    public String getModuleTitle() {
        return moduleTitle;
    }

    /**
     * 
     * @param moduleTitle
     *     The moduleTitle
     */
    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    /**
     * 
     * @return
     *     The moduleGuideType
     */
    public String getModuleGuideType() {
        return moduleGuideType;
    }

    /**
     * 
     * @param moduleGuideType
     *     The moduleGuideType
     */
    public void setModuleGuideType(String moduleGuideType) {
        this.moduleGuideType = moduleGuideType;
    }

    /**
     * 
     * @return
     *     The moduleGuideContent
     */
    public String getModuleGuideContent() {
        return moduleGuideContent;
    }

    /**
     * 
     * @param moduleGuideContent
     *     The moduleGuideContent
     */
    public void setModuleGuideContent(String moduleGuideContent) {
        this.moduleGuideContent = moduleGuideContent;
    }

    /**
     * 
     * @return
     *     The isHot
     */
    public String getIsHot() {
        return isHot;
    }

    /**
     * 
     * @param isHot
     *     The isHot
     */
    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    /**
     * 
     * @return
     *     The moduleContentList
     */
    public List<ModuleContentList> getModuleContentList() {
        return moduleContentList;
    }

    /**
     * 
     * @param moduleContentList
     *     The moduleContentList
     */
    public void setModuleContentList(List<ModuleContentList> moduleContentList) {
        this.moduleContentList = moduleContentList;
    }

}
