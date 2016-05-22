package com.example.model.header1;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Body {

    @Expose
    private String sceneCode;
    @Expose
    private String pageCode;
    @Expose
    private String uniqueId;
    @Expose
    private String defaultTemplateType;
    @Expose
    private ChangZhu changZhu;
    @Expose
    private List<Layout> layout = new ArrayList<Layout>();
    @Expose
    private Search search;
    @Expose
    private Background background;

    /**
     * 
     * @return
     *     The sceneCode
     */
    public String getSceneCode() {
        return sceneCode;
    }

    /**
     * 
     * @param sceneCode
     *     The sceneCode
     */
    public void setSceneCode(String sceneCode) {
        this.sceneCode = sceneCode;
    }

    /**
     * 
     * @return
     *     The pageCode
     */
    public String getPageCode() {
        return pageCode;
    }

    /**
     * 
     * @param pageCode
     *     The pageCode
     */
    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    /**
     * 
     * @return
     *     The uniqueId
     */
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * 
     * @param uniqueId
     *     The uniqueId
     */
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    /**
     * 
     * @return
     *     The defaultTemplateType
     */
    public String getDefaultTemplateType() {
        return defaultTemplateType;
    }

    /**
     * 
     * @param defaultTemplateType
     *     The defaultTemplateType
     */
    public void setDefaultTemplateType(String defaultTemplateType) {
        this.defaultTemplateType = defaultTemplateType;
    }

    /**
     * 
     * @return
     *     The changZhu
     */
    public ChangZhu getChangZhu() {
        return changZhu;
    }

    /**
     * 
     * @param changZhu
     *     The changZhu
     */
    public void setChangZhu(ChangZhu changZhu) {
        this.changZhu = changZhu;
    }

    /**
     * 
     * @return
     *     The layout
     */
    public List<Layout> getLayout() {
        return layout;
    }

    /**
     * 
     * @param layout
     *     The layout
     */
    public void setLayout(List<Layout> layout) {
        this.layout = layout;
    }

    /**
     * 
     * @return
     *     The search
     */
    public Search getSearch() {
        return search;
    }

    /**
     * 
     * @param search
     *     The search
     */
    public void setSearch(Search search) {
        this.search = search;
    }

    /**
     * 
     * @return
     *     The background
     */
    public Background getBackground() {
        return background;
    }

    /**
     * 
     * @param background
     *     The background
     */
    public void setBackground(Background background) {
        this.background = background;
    }

}
