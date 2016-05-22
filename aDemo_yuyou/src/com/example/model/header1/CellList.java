package com.example.model.header1;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class CellList {

    @Expose
    private String lineColor;
    @Expose
    private String innerLineColor;
    @Expose
    private String backgroundColor;
    @Expose
    private String backgroundImageUrl;
    @Expose
    private String cellType;
    @Expose
    private String cellName;
    @Expose
    private String breakNum;
    @Expose
    private String paddingType;
    @Expose
    private String sortNo;
    @Expose
    private String isAsyn;
    @Expose
    private String tag;
    @Expose
    private ExtendInfo extendInfo;
    @Expose
    private List<ItemList> itemList = new ArrayList<ItemList>();
    @Expose
    private EventTag___ eventTag;

    /**
     * 
     * @return
     *     The lineColor
     */
    public String getLineColor() {
        return lineColor;
    }

    /**
     * 
     * @param lineColor
     *     The lineColor
     */
    public void setLineColor(String lineColor) {
        this.lineColor = lineColor;
    }

    /**
     * 
     * @return
     *     The innerLineColor
     */
    public String getInnerLineColor() {
        return innerLineColor;
    }

    /**
     * 
     * @param innerLineColor
     *     The innerLineColor
     */
    public void setInnerLineColor(String innerLineColor) {
        this.innerLineColor = innerLineColor;
    }

    /**
     * 
     * @return
     *     The backgroundColor
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * 
     * @param backgroundColor
     *     The backgroundColor
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * 
     * @return
     *     The backgroundImageUrl
     */
    public String getBackgroundImageUrl() {
        return backgroundImageUrl;
    }

    /**
     * 
     * @param backgroundImageUrl
     *     The backgroundImageUrl
     */
    public void setBackgroundImageUrl(String backgroundImageUrl) {
        this.backgroundImageUrl = backgroundImageUrl;
    }

    /**
     * 
     * @return
     *     The cellType
     */
    public String getCellType() {
        return cellType;
    }

    /**
     * 
     * @param cellType
     *     The cellType
     */
    public void setCellType(String cellType) {
        this.cellType = cellType;
    }

    /**
     * 
     * @return
     *     The cellName
     */
    public String getCellName() {
        return cellName;
    }

    /**
     * 
     * @param cellName
     *     The cellName
     */
    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    /**
     * 
     * @return
     *     The breakNum
     */
    public String getBreakNum() {
        return breakNum;
    }

    /**
     * 
     * @param breakNum
     *     The breakNum
     */
    public void setBreakNum(String breakNum) {
        this.breakNum = breakNum;
    }

    /**
     * 
     * @return
     *     The paddingType
     */
    public String getPaddingType() {
        return paddingType;
    }

    /**
     * 
     * @param paddingType
     *     The paddingType
     */
    public void setPaddingType(String paddingType) {
        this.paddingType = paddingType;
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
     *     The isAsyn
     */
    public String getIsAsyn() {
        return isAsyn;
    }

    /**
     * 
     * @param isAsyn
     *     The isAsyn
     */
    public void setIsAsyn(String isAsyn) {
        this.isAsyn = isAsyn;
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
     *     The extendInfo
     */
    public ExtendInfo getExtendInfo() {
        return extendInfo;
    }

    /**
     * 
     * @param extendInfo
     *     The extendInfo
     */
    public void setExtendInfo(ExtendInfo extendInfo) {
        this.extendInfo = extendInfo;
    }

    /**
     * 
     * @return
     *     The itemList
     */
    public List<ItemList> getItemList() {
        return itemList;
    }

    /**
     * 
     * @param itemList
     *     The itemList
     */
    public void setItemList(List<ItemList> itemList) {
        this.itemList = itemList;
    }

    /**
     * 
     * @return
     *     The eventTag
     */
    public EventTag___ getEventTag() {
        return eventTag;
    }

    /**
     * 
     * @param eventTag
     *     The eventTag
     */
    public void setEventTag(EventTag___ eventTag) {
        this.eventTag = eventTag;
    }

}
