package com.example.model.header2.kuaileduantu;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class EventTag_ {

    @Expose
    private List<DefaultEvent_> defaultEvent = new ArrayList<DefaultEvent_>();
    @Expose
    private HoverEvent_ hoverEvent;
    @Expose
    private DianZanEvent_ dianZanEvent;

    /**
     * 
     * @return
     *     The defaultEvent
     */
    public List<DefaultEvent_> getDefaultEvent() {
        return defaultEvent;
    }

    /**
     * 
     * @param defaultEvent
     *     The defaultEvent
     */
    public void setDefaultEvent(List<DefaultEvent_> defaultEvent) {
        this.defaultEvent = defaultEvent;
    }

    /**
     * 
     * @return
     *     The hoverEvent
     */
    public HoverEvent_ getHoverEvent() {
        return hoverEvent;
    }

    /**
     * 
     * @param hoverEvent
     *     The hoverEvent
     */
    public void setHoverEvent(HoverEvent_ hoverEvent) {
        this.hoverEvent = hoverEvent;
    }

    /**
     * 
     * @return
     *     The dianZanEvent
     */
    public DianZanEvent_ getDianZanEvent() {
        return dianZanEvent;
    }

    /**
     * 
     * @param dianZanEvent
     *     The dianZanEvent
     */
    public void setDianZanEvent(DianZanEvent_ dianZanEvent) {
        this.dianZanEvent = dianZanEvent;
    }

}
