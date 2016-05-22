package com.example.model.header2.kuaileduantu;

import com.google.gson.annotations.Expose;

public class HoverEvent_ {

    @Expose
    private String eventId;
    @Expose
    private String eventParameter;
    @Expose
    private String tag;

    /**
     * 
     * @return
     *     The eventId
     */
    public String getEventId() {
        return eventId;
    }

    /**
     * 
     * @param eventId
     *     The eventId
     */
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    /**
     * 
     * @return
     *     The eventParameter
     */
    public String getEventParameter() {
        return eventParameter;
    }

    /**
     * 
     * @param eventParameter
     *     The eventParameter
     */
    public void setEventParameter(String eventParameter) {
        this.eventParameter = eventParameter;
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

}
