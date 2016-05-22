package com.example.model.mudidi2;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class CellItem {

    @Expose
    private String cellProgressPreText;
    @Expose
    private String cellRankPreText;
    @Expose
    private String cellRanktext;
    @Expose
    private String cellAtmosphereUrl;
    @Expose
    private String cellProgressValue;
    @Expose
    private String cellProgressImgUrl;
    @Expose
    private String cellCenterImgUrl;
    @Expose
    private String cellDirectUrl;
    @Expose
    private String cellImage;
    @Expose
    private String cellPrice;
    @Expose
    private String cellSubTitle;
    @Expose
    private String cellTitle;
    @Expose
    private List<Object> tagItem = new ArrayList<Object>();
    @Expose
    private String groupName;
    @Expose
    private String groupColor;
    @Expose
    private String groupIcon;
    @Expose
    private String groupType;
    @Expose
    private String isOverSea;
    @Expose
    private String isShowGroupName;
    @Expose
    private String resourceName;
    @Expose
    private String resourceId;
    @Expose
    private String cellPriceUnit;

    /**
     * 
     * @return
     *     The cellProgressPreText
     */
    public String getCellProgressPreText() {
        return cellProgressPreText;
    }

    /**
     * 
     * @param cellProgressPreText
     *     The cellProgressPreText
     */
    public void setCellProgressPreText(String cellProgressPreText) {
        this.cellProgressPreText = cellProgressPreText;
    }

    /**
     * 
     * @return
     *     The cellRankPreText
     */
    public String getCellRankPreText() {
        return cellRankPreText;
    }

    /**
     * 
     * @param cellRankPreText
     *     The cellRankPreText
     */
    public void setCellRankPreText(String cellRankPreText) {
        this.cellRankPreText = cellRankPreText;
    }

    /**
     * 
     * @return
     *     The cellRanktext
     */
    public String getCellRanktext() {
        return cellRanktext;
    }

    /**
     * 
     * @param cellRanktext
     *     The cellRanktext
     */
    public void setCellRanktext(String cellRanktext) {
        this.cellRanktext = cellRanktext;
    }

    /**
     * 
     * @return
     *     The cellAtmosphereUrl
     */
    public String getCellAtmosphereUrl() {
        return cellAtmosphereUrl;
    }

    /**
     * 
     * @param cellAtmosphereUrl
     *     The cellAtmosphereUrl
     */
    public void setCellAtmosphereUrl(String cellAtmosphereUrl) {
        this.cellAtmosphereUrl = cellAtmosphereUrl;
    }

    /**
     * 
     * @return
     *     The cellProgressValue
     */
    public String getCellProgressValue() {
        return cellProgressValue;
    }

    /**
     * 
     * @param cellProgressValue
     *     The cellProgressValue
     */
    public void setCellProgressValue(String cellProgressValue) {
        this.cellProgressValue = cellProgressValue;
    }

    /**
     * 
     * @return
     *     The cellProgressImgUrl
     */
    public String getCellProgressImgUrl() {
        return cellProgressImgUrl;
    }

    /**
     * 
     * @param cellProgressImgUrl
     *     The cellProgressImgUrl
     */
    public void setCellProgressImgUrl(String cellProgressImgUrl) {
        this.cellProgressImgUrl = cellProgressImgUrl;
    }

    /**
     * 
     * @return
     *     The cellCenterImgUrl
     */
    public String getCellCenterImgUrl() {
        return cellCenterImgUrl;
    }

    /**
     * 
     * @param cellCenterImgUrl
     *     The cellCenterImgUrl
     */
    public void setCellCenterImgUrl(String cellCenterImgUrl) {
        this.cellCenterImgUrl = cellCenterImgUrl;
    }

    /**
     * 
     * @return
     *     The cellDirectUrl
     */
    public String getCellDirectUrl() {
        return cellDirectUrl;
    }

    /**
     * 
     * @param cellDirectUrl
     *     The cellDirectUrl
     */
    public void setCellDirectUrl(String cellDirectUrl) {
        this.cellDirectUrl = cellDirectUrl;
    }

    /**
     * 
     * @return
     *     The cellImage
     */
    public String getCellImage() {
        return cellImage;
    }

    /**
     * 
     * @param cellImage
     *     The cellImage
     */
    public void setCellImage(String cellImage) {
        this.cellImage = cellImage;
    }

    /**
     * 
     * @return
     *     The cellPrice
     */
    public String getCellPrice() {
        return cellPrice;
    }

    /**
     * 
     * @param cellPrice
     *     The cellPrice
     */
    public void setCellPrice(String cellPrice) {
        this.cellPrice = cellPrice;
    }

    /**
     * 
     * @return
     *     The cellSubTitle
     */
    public String getCellSubTitle() {
        return cellSubTitle;
    }

    /**
     * 
     * @param cellSubTitle
     *     The cellSubTitle
     */
    public void setCellSubTitle(String cellSubTitle) {
        this.cellSubTitle = cellSubTitle;
    }

    /**
     * 
     * @return
     *     The cellTitle
     */
    public String getCellTitle() {
        return cellTitle;
    }

    /**
     * 
     * @param cellTitle
     *     The cellTitle
     */
    public void setCellTitle(String cellTitle) {
        this.cellTitle = cellTitle;
    }

    /**
     * 
     * @return
     *     The tagItem
     */
    public List<Object> getTagItem() {
        return tagItem;
    }

    /**
     * 
     * @param tagItem
     *     The tagItem
     */
    public void setTagItem(List<Object> tagItem) {
        this.tagItem = tagItem;
    }

    /**
     * 
     * @return
     *     The groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 
     * @param groupName
     *     The groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 
     * @return
     *     The groupColor
     */
    public String getGroupColor() {
        return groupColor;
    }

    /**
     * 
     * @param groupColor
     *     The groupColor
     */
    public void setGroupColor(String groupColor) {
        this.groupColor = groupColor;
    }

    /**
     * 
     * @return
     *     The groupIcon
     */
    public String getGroupIcon() {
        return groupIcon;
    }

    /**
     * 
     * @param groupIcon
     *     The groupIcon
     */
    public void setGroupIcon(String groupIcon) {
        this.groupIcon = groupIcon;
    }

    /**
     * 
     * @return
     *     The groupType
     */
    public String getGroupType() {
        return groupType;
    }

    /**
     * 
     * @param groupType
     *     The groupType
     */
    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    /**
     * 
     * @return
     *     The isOverSea
     */
    public String getIsOverSea() {
        return isOverSea;
    }

    /**
     * 
     * @param isOverSea
     *     The isOverSea
     */
    public void setIsOverSea(String isOverSea) {
        this.isOverSea = isOverSea;
    }

    /**
     * 
     * @return
     *     The isShowGroupName
     */
    public String getIsShowGroupName() {
        return isShowGroupName;
    }

    /**
     * 
     * @param isShowGroupName
     *     The isShowGroupName
     */
    public void setIsShowGroupName(String isShowGroupName) {
        this.isShowGroupName = isShowGroupName;
    }

    /**
     * 
     * @return
     *     The resourceName
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * 
     * @param resourceName
     *     The resourceName
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * 
     * @return
     *     The resourceId
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * 
     * @param resourceId
     *     The resourceId
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 
     * @return
     *     The cellPriceUnit
     */
    public String getCellPriceUnit() {
        return cellPriceUnit;
    }

    /**
     * 
     * @param cellPriceUnit
     *     The cellPriceUnit
     */
    public void setCellPriceUnit(String cellPriceUnit) {
        this.cellPriceUnit = cellPriceUnit;
    }

}
