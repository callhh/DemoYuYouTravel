package com.example.model.mudidi2;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class GroupList {

    @Expose
    private String groupLimitCount;
    @Expose
    private String groupName;
    @Expose
    private String groupType;
    @Expose
    private List<CellItem> cellItem = new ArrayList<CellItem>();
    @Expose
    private String isShowGroupName;
    @Expose
    private String groupNameColor;
    @Expose
    private String groupNameIcon;

    /**
     * 
     * @return
     *     The groupLimitCount
     */
    public String getGroupLimitCount() {
        return groupLimitCount;
    }

    /**
     * 
     * @param groupLimitCount
     *     The groupLimitCount
     */
    public void setGroupLimitCount(String groupLimitCount) {
        this.groupLimitCount = groupLimitCount;
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
     *     The cellItem
     */
    public List<CellItem> getCellItem() {
        return cellItem;
    }

    /**
     * 
     * @param cellItem
     *     The cellItem
     */
    public void setCellItem(List<CellItem> cellItem) {
        this.cellItem = cellItem;
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
     *     The groupNameColor
     */
    public String getGroupNameColor() {
        return groupNameColor;
    }

    /**
     * 
     * @param groupNameColor
     *     The groupNameColor
     */
    public void setGroupNameColor(String groupNameColor) {
        this.groupNameColor = groupNameColor;
    }

    /**
     * 
     * @return
     *     The groupNameIcon
     */
    public String getGroupNameIcon() {
        return groupNameIcon;
    }

    /**
     * 
     * @param groupNameIcon
     *     The groupNameIcon
     */
    public void setGroupNameIcon(String groupNameIcon) {
        this.groupNameIcon = groupNameIcon;
    }

}
