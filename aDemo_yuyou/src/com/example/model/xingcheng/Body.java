package com.example.model.xingcheng;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Body {

    @Expose
    private String travelAssistanttitle;
    @Expose
    private List<RecommendList> recommendList = new ArrayList<RecommendList>();
    @Expose
    private String isCache;

    /**
     * 
     * @return
     *     The travelAssistanttitle
     */
    public String getTravelAssistanttitle() {
        return travelAssistanttitle;
    }

    /**
     * 
     * @param travelAssistanttitle
     *     The travelAssistanttitle
     */
    public void setTravelAssistanttitle(String travelAssistanttitle) {
        this.travelAssistanttitle = travelAssistanttitle;
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

}
