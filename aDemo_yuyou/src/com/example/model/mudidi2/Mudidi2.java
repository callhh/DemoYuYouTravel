package com.example.model.mudidi2;

import com.google.gson.annotations.Expose;

public class Mudidi2 {

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
