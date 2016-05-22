package com.example.model.header1;

import com.google.gson.annotations.Expose;

public class ChangZhu {

    @Expose
    private String changZhuCityId;

    /**
     * 
     * @return
     *     The changZhuCityId
     */
    public String getChangZhuCityId() {
        return changZhuCityId;
    }

    /**
     * 
     * @param changZhuCityId
     *     The changZhuCityId
     */
    public void setChangZhuCityId(String changZhuCityId) {
        this.changZhuCityId = changZhuCityId;
    }

}
