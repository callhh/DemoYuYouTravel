package com.example.model.mudidi1;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class CategoryList {

    @Expose
    private AnimationShow animationShow;
    @Expose
    private String displayType;
    @Expose
    private String categoryIdSource;
    @Expose
    private String isActivity;
    @Expose
    private String categoryBgUrl;
    @Expose
    private String bgImgUrl;
    @Expose
    private String categoryId;
    @Expose
    private String categoryName;
    @Expose
    private List<TagItem> tagItem = new ArrayList<TagItem>();
    @Expose
    private String categoryType;
    @Expose
    private String categoryUrl;

    /**
     * 
     * @return
     *     The animationShow
     */
    public AnimationShow getAnimationShow() {
        return animationShow;
    }

    /**
     * 
     * @param animationShow
     *     The animationShow
     */
    public void setAnimationShow(AnimationShow animationShow) {
        this.animationShow = animationShow;
    }

    /**
     * 
     * @return
     *     The displayType
     */
    public String getDisplayType() {
        return displayType;
    }

    /**
     * 
     * @param displayType
     *     The displayType
     */
    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    /**
     * 
     * @return
     *     The categoryIdSource
     */
    public String getCategoryIdSource() {
        return categoryIdSource;
    }

    /**
     * 
     * @param categoryIdSource
     *     The categoryIdSource
     */
    public void setCategoryIdSource(String categoryIdSource) {
        this.categoryIdSource = categoryIdSource;
    }

    /**
     * 
     * @return
     *     The isActivity
     */
    public String getIsActivity() {
        return isActivity;
    }

    /**
     * 
     * @param isActivity
     *     The isActivity
     */
    public void setIsActivity(String isActivity) {
        this.isActivity = isActivity;
    }

    /**
     * 
     * @return
     *     The categoryBgUrl
     */
    public String getCategoryBgUrl() {
        return categoryBgUrl;
    }

    /**
     * 
     * @param categoryBgUrl
     *     The categoryBgUrl
     */
    public void setCategoryBgUrl(String categoryBgUrl) {
        this.categoryBgUrl = categoryBgUrl;
    }

    /**
     * 
     * @return
     *     The bgImgUrl
     */
    public String getBgImgUrl() {
        return bgImgUrl;
    }

    /**
     * 
     * @param bgImgUrl
     *     The bgImgUrl
     */
    public void setBgImgUrl(String bgImgUrl) {
        this.bgImgUrl = bgImgUrl;
    }

    /**
     * 
     * @return
     *     The categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 
     * @param categoryId
     *     The categoryId
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 
     * @return
     *     The categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 
     * @param categoryName
     *     The categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 
     * @return
     *     The tagItem
     */
    public List<TagItem> getTagItem() {
        return tagItem;
    }

    /**
     * 
     * @param tagItem
     *     The tagItem
     */
    public void setTagItem(List<TagItem> tagItem) {
        this.tagItem = tagItem;
    }

    /**
     * 
     * @return
     *     The categoryType
     */
    public String getCategoryType() {
        return categoryType;
    }

    /**
     * 
     * @param categoryType
     *     The categoryType
     */
    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    /**
     * 
     * @return
     *     The categoryUrl
     */
    public String getCategoryUrl() {
        return categoryUrl;
    }

    /**
     * 
     * @param categoryUrl
     *     The categoryUrl
     */
    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

}
