package com.example.model.header1;

import com.google.gson.annotations.Expose;

public class EventTag {

    @Expose
    private TopCityEvent topCityEvent;
    @Expose
    private TopTelEvent topTelEvent;
    @Expose
    private TopSearchEvent topSearchEvent;

    /**
     * 
     * @return
     *     The topCityEvent
     */
    public TopCityEvent getTopCityEvent() {
        return topCityEvent;
    }

    /**
     * 
     * @param topCityEvent
     *     The topCityEvent
     */
    public void setTopCityEvent(TopCityEvent topCityEvent) {
        this.topCityEvent = topCityEvent;
    }

    /**
     * 
     * @return
     *     The topTelEvent
     */
    public TopTelEvent getTopTelEvent() {
        return topTelEvent;
    }

    /**
     * 
     * @param topTelEvent
     *     The topTelEvent
     */
    public void setTopTelEvent(TopTelEvent topTelEvent) {
        this.topTelEvent = topTelEvent;
    }

    /**
     * 
     * @return
     *     The topSearchEvent
     */
    public TopSearchEvent getTopSearchEvent() {
        return topSearchEvent;
    }

    /**
     * 
     * @param topSearchEvent
     *     The topSearchEvent
     */
    public void setTopSearchEvent(TopSearchEvent topSearchEvent) {
        this.topSearchEvent = topSearchEvent;
    }

}
