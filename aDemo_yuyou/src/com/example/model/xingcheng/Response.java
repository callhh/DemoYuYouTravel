package com.example.model.xingcheng;

import com.google.gson.annotations.Expose;

public class Response {

    @Expose
    private Header header;
    @Expose
    private Body body;

    /**
     * 
     * @return
     *     The header
     */
    public Header getHeader() {
        return header;
    }

    /**
     * 
     * @param header
     *     The header
     */
    public void setHeader(Header header) {
        this.header = header;
    }

    /**
     * 
     * @return
     *     The body
     */
    public Body getBody() {
        return body;
    }

    /**
     * 
     * @param body
     *     The body
     */
    public void setBody(Body body) {
        this.body = body;
    }

}
