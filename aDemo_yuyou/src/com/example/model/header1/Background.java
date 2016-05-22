package com.example.model.header1;

import com.google.gson.annotations.Expose;

public class Background {

    @Expose
    private String pullDownImageUrl;

    /**
     * 
     * @return
     *     The pullDownImageUrl
     */
    public String getPullDownImageUrl() {
        return pullDownImageUrl;
    }

    /**
     * 
     * @param pullDownImageUrl
     *     The pullDownImageUrl
     */
    public void setPullDownImageUrl(String pullDownImageUrl) {
        this.pullDownImageUrl = pullDownImageUrl;
    }

}
