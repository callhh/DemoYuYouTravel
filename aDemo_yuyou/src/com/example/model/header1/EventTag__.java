package com.example.model.header1;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class EventTag__ {

    @Expose
    private List<DefaultEvent_> defaultEvent = new ArrayList<DefaultEvent_>();

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

}
