package com.example.model.header1;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class EventTag_ {

    @Expose
    private List<DefaultEvent> defaultEvent = new ArrayList<DefaultEvent>();

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

}
