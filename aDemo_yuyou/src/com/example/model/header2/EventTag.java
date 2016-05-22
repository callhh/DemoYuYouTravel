package com.example.model.header2;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class EventTag {

    @Expose
    private List<DefaultEvent> defaultEvent = new ArrayList<DefaultEvent>();
    @Expose
    private HoverEvent hoverEvent;
    @Expose
    private DianZanEvent dianZanEvent;

    /**
     * 
     * @return
     *     The defaultEvent
     */
    public List<DefaultEvent> getDefaultEvent() {
        return defaultEvent;
    }

    /**
     * 
     * @param defaultEvent
     *     The defaultEvent
     */
    public void setDefaultEvent(List<DefaultEvent> defaultEvent) {
        this.defaultEvent = defaultEvent;
    }

    /**
     * 
     * @return
     *     The hoverEvent
     */
    public HoverEvent getHoverEvent() {
        return hoverEvent;
    }

    /**
     * 
     * @param hoverEvent
     *     The hoverEvent
     */
    public void setHoverEvent(HoverEvent hoverEvent) {
        this.hoverEvent = hoverEvent;
    }

    /**
     * 
     * @return
     *     The dianZanEvent
     */
    public DianZanEvent getDianZanEvent() {
        return dianZanEvent;
    }

    /**
     * 
     * @param dianZanEvent
     *     The dianZanEvent
     */
    public void setDianZanEvent(DianZanEvent dianZanEvent) {
        this.dianZanEvent = dianZanEvent;
    }

}
