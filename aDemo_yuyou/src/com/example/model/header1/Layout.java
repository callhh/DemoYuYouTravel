package com.example.model.header1;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Layout {

    @Expose
    private String templateType;
    @Expose
    private String templateName;
    @Expose
    private String isDefault;
    @Expose
    private EventTag eventTag;
    @Expose
    private Bottom bottom;
    @Expose
    private Top top;
    @Expose
    private List<CellList> cellList = new ArrayList<CellList>();

    /**
     * 
     * @return
     *     The templateType
     */
    public String getTemplateType() {
        return templateType;
    }

    /**
     * 
     * @param templateType
     *     The templateType
     */
    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    /**
     * 
     * @return
     *     The templateName
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 
     * @param templateName
     *     The templateName
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     * 
     * @return
     *     The isDefault
     */
    public String getIsDefault() {
        return isDefault;
    }

    /**
     * 
     * @param isDefault
     *     The isDefault
     */
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
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

    /**
     * 
     * @return
     *     The bottom
     */
    public Bottom getBottom() {
        return bottom;
    }

    /**
     * 
     * @param bottom
     *     The bottom
     */
    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }

    /**
     * 
     * @return
     *     The top
     */
    public Top getTop() {
        return top;
    }

    /**
     * 
     * @param top
     *     The top
     */
    public void setTop(Top top) {
        this.top = top;
    }

    /**
     * 
     * @return
     *     The cellList
     */
    public List<CellList> getCellList() {
        return cellList;
    }

    /**
     * 
     * @param cellList
     *     The cellList
     */
    public void setCellList(List<CellList> cellList) {
        this.cellList = cellList;
    }

}
