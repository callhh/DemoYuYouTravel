package com.example.model.header2;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Body {

    @Expose
    private String recommendTitle;
    @Expose
    private String imageModelType;
    @Expose
    private List<MainMenuList> mainMenuList = new ArrayList<MainMenuList>();
    @Expose
    private List<RecommendList> recommendList = new ArrayList<RecommendList>();
    @Expose
    private List<SubMenuList> subMenuList = new ArrayList<SubMenuList>();
    @Expose
    private PageInfo pageInfo;

    /**
     * 
     * @return
     *     The recommendTitle
     */
    public String getRecommendTitle() {
        return recommendTitle;
    }

    /**
     * 
     * @param recommendTitle
     *     The recommendTitle
     */
    public void setRecommendTitle(String recommendTitle) {
        this.recommendTitle = recommendTitle;
    }

    /**
     * 
     * @return
     *     The imageModelType
     */
    public String getImageModelType() {
        return imageModelType;
    }

    /**
     * 
     * @param imageModelType
     *     The imageModelType
     */
    public void setImageModelType(String imageModelType) {
        this.imageModelType = imageModelType;
    }

    /**
     * 
     * @return
     *     The mainMenuList
     */
    public List<MainMenuList> getMainMenuList() {
        return mainMenuList;
    }

    /**
     * 
     * @param mainMenuList
     *     The mainMenuList
     */
    public void setMainMenuList(List<MainMenuList> mainMenuList) {
        this.mainMenuList = mainMenuList;
    }

    /**
     * 
     * @return
     *     The recommendList
     */
    public List<RecommendList> getRecommendList() {
        return recommendList;
    }

    /**
     * 
     * @param recommendList
     *     The recommendList
     */
    public void setRecommendList(List<RecommendList> recommendList) {
        this.recommendList = recommendList;
    }

    /**
     * 
     * @return
     *     The subMenuList
     */
    public List<SubMenuList> getSubMenuList() {
        return subMenuList;
    }

    /**
     * 
     * @param subMenuList
     *     The subMenuList
     */
    public void setSubMenuList(List<SubMenuList> subMenuList) {
        this.subMenuList = subMenuList;
    }

    /**
     * 
     * @return
     *     The pageInfo
     */
    public PageInfo getPageInfo() {
        return pageInfo;
    }

    /**
     * 
     * @param pageInfo
     *     The pageInfo
     */
    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

}
