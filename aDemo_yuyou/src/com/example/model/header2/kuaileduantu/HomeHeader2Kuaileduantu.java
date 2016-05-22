package com.example.model.header2.kuaileduantu;

import com.google.gson.annotations.Expose;

public class HomeHeader2Kuaileduantu {

    @Expose
    private Response response;

    /**
     * 
     * @return
     *     The response
     */
    public Response getResponse() {
        return response;
    }

    /**
     * 
     * @param response
     *     The response
     */
    public void setResponse(Response response) {
        this.response = response;
    }

}
