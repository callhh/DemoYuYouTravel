package com.example.model.faxian;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Body {

    @Expose
    private RecommendList recommendList;
    @Expose
    private HotSaleList hotSaleList;
    @Expose
    private FreshPlayWayList freshPlayWayList;
    @Expose
    private HotDestinationList hotDestinationList;
    @Expose
    private NearbyDestinationList nearbyDestinationList;
    @Expose
    private ExpertTripList expertTripList;
    @Expose
    private CommunityCenterList communityCenterList;
    @Expose
    private List<ThemeList> themeList = new ArrayList<ThemeList>();
    @Expose
    private AreaInfo areaInfo;
    @Expose
    private String isForeign;
    @Expose
    private String isCache;
    @Expose
    private String areaId;
    @Expose
    private String areaName;

    /**
     * 
     * @return
     *     The recommendList
     */
    public RecommendList getRecommendList() {
        return recommendList;
    }

    /**
     * 
     * @param recommendList
     *     The recommendList
     */
    public void setRecommendList(RecommendList recommendList) {
        this.recommendList = recommendList;
    }

    /**
     * 
     * @return
     *     The hotSaleList
     */
    public HotSaleList getHotSaleList() {
        return hotSaleList;
    }

    /**
     * 
     * @param hotSaleList
     *     The hotSaleList
     */
    public void setHotSaleList(HotSaleList hotSaleList) {
        this.hotSaleList = hotSaleList;
    }

    /**
     * 
     * @return
     *     The freshPlayWayList
     */
    public FreshPlayWayList getFreshPlayWayList() {
        return freshPlayWayList;
    }

    /**
     * 
     * @param freshPlayWayList
     *     The freshPlayWayList
     */
    public void setFreshPlayWayList(FreshPlayWayList freshPlayWayList) {
        this.freshPlayWayList = freshPlayWayList;
    }

    /**
     * 
     * @return
     *     The hotDestinationList
     */
    public HotDestinationList getHotDestinationList() {
        return hotDestinationList;
    }

    /**
     * 
     * @param hotDestinationList
     *     The hotDestinationList
     */
    public void setHotDestinationList(HotDestinationList hotDestinationList) {
        this.hotDestinationList = hotDestinationList;
    }

    /**
     * 
     * @return
     *     The nearbyDestinationList
     */
    public NearbyDestinationList getNearbyDestinationList() {
        return nearbyDestinationList;
    }

    /**
     * 
     * @param nearbyDestinationList
     *     The nearbyDestinationList
     */
    public void setNearbyDestinationList(NearbyDestinationList nearbyDestinationList) {
        this.nearbyDestinationList = nearbyDestinationList;
    }

    /**
     * 
     * @return
     *     The expertTripList
     */
    public ExpertTripList getExpertTripList() {
        return expertTripList;
    }

    /**
     * 
     * @param expertTripList
     *     The expertTripList
     */
    public void setExpertTripList(ExpertTripList expertTripList) {
        this.expertTripList = expertTripList;
    }

    /**
     * 
     * @return
     *     The communityCenterList
     */
    public CommunityCenterList getCommunityCenterList() {
        return communityCenterList;
    }

    /**
     * 
     * @param communityCenterList
     *     The communityCenterList
     */
    public void setCommunityCenterList(CommunityCenterList communityCenterList) {
        this.communityCenterList = communityCenterList;
    }

    /**
     * 
     * @return
     *     The themeList
     */
    public List<ThemeList> getThemeList() {
        return themeList;
    }

    /**
     * 
     * @param themeList
     *     The themeList
     */
    public void setThemeList(List<ThemeList> themeList) {
        this.themeList = themeList;
    }

    /**
     * 
     * @return
     *     The areaInfo
     */
    public AreaInfo getAreaInfo() {
        return areaInfo;
    }

    /**
     * 
     * @param areaInfo
     *     The areaInfo
     */
    public void setAreaInfo(AreaInfo areaInfo) {
        this.areaInfo = areaInfo;
    }

    /**
     * 
     * @return
     *     The isForeign
     */
    public String getIsForeign() {
        return isForeign;
    }

    /**
     * 
     * @param isForeign
     *     The isForeign
     */
    public void setIsForeign(String isForeign) {
        this.isForeign = isForeign;
    }

    /**
     * 
     * @return
     *     The isCache
     */
    public String getIsCache() {
        return isCache;
    }

    /**
     * 
     * @param isCache
     *     The isCache
     */
    public void setIsCache(String isCache) {
        this.isCache = isCache;
    }

    /**
     * 
     * @return
     *     The areaId
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 
     * @param areaId
     *     The areaId
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * 
     * @return
     *     The areaName
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 
     * @param areaName
     *     The areaName
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

}
