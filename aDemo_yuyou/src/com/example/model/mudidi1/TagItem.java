package com.example.model.mudidi1;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class TagItem {

    @Expose
    private String tagGuid;
    @Expose
    private String tagIsAlwaysShow;
    @Expose
    private String tagColor;
    @Expose
    private String tagIcon;
    @Expose
    private String tagPosition;
    @Expose
    private String tagText;
    @Expose
    private String tagType;
    @Expose
    private String tagId;
    @Expose
    private List<Object> labelItem = new ArrayList<Object>();

    /**
     * 
     * @return
     *     The tagGuid
     */
    public String getTagGuid() {
        return tagGuid;
    }

    /**
     * 
     * @param tagGuid
     *     The tagGuid
     */
    public void setTagGuid(String tagGuid) {
        this.tagGuid = tagGuid;
    }

    /**
     * 
     * @return
     *     The tagIsAlwaysShow
     */
    public String getTagIsAlwaysShow() {
        return tagIsAlwaysShow;
    }

    /**
     * 
     * @param tagIsAlwaysShow
     *     The tagIsAlwaysShow
     */
    public void setTagIsAlwaysShow(String tagIsAlwaysShow) {
        this.tagIsAlwaysShow = tagIsAlwaysShow;
    }

    /**
     * 
     * @return
     *     The tagColor
     */
    public String getTagColor() {
        return tagColor;
    }

    /**
     * 
     * @param tagColor
     *     The tagColor
     */
    public void setTagColor(String tagColor) {
        this.tagColor = tagColor;
    }

    /**
     * 
     * @return
     *     The tagIcon
     */
    public String getTagIcon() {
        return tagIcon;
    }

    /**
     * 
     * @param tagIcon
     *     The tagIcon
     */
    public void setTagIcon(String tagIcon) {
        this.tagIcon = tagIcon;
    }

    /**
     * 
     * @return
     *     The tagPosition
     */
    public String getTagPosition() {
        return tagPosition;
    }

    /**
     * 
     * @param tagPosition
     *     The tagPosition
     */
    public void setTagPosition(String tagPosition) {
        this.tagPosition = tagPosition;
    }

    /**
     * 
     * @return
     *     The tagText
     */
    public String getTagText() {
        return tagText;
    }

    /**
     * 
     * @param tagText
     *     The tagText
     */
    public void setTagText(String tagText) {
        this.tagText = tagText;
    }

    /**
     * 
     * @return
     *     The tagType
     */
    public String getTagType() {
        return tagType;
    }

    /**
     * 
     * @param tagType
     *     The tagType
     */
    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    /**
     * 
     * @return
     *     The tagId
     */
    public String getTagId() {
        return tagId;
    }

    /**
     * 
     * @param tagId
     *     The tagId
     */
    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    /**
     * 
     * @return
     *     The labelItem
     */
    public List<Object> getLabelItem() {
        return labelItem;
    }

    /**
     * 
     * @param labelItem
     *     The labelItem
     */
    public void setLabelItem(List<Object> labelItem) {
        this.labelItem = labelItem;
    }

}
