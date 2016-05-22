package com.example.model.header1;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class EventTag___ {

    @Expose
    private List<DefaultEvent__> defaultEvent = new ArrayList<DefaultEvent__>();

    /**
     * 
     * @return
     *     The defaultEvent
     */
    public List<DefaultEvent__> getDefaultEvent() {
        return defaultEvent;
    }

    /**
     * 
     * @param defaultEvent
     *     The defaultEvent
     */
    public void setDefaultEvent(List<DefaultEvent__> defaultEvent) {
        this.defaultEvent = defaultEvent;
    }

}
