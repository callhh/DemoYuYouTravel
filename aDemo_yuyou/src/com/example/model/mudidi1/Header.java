package com.example.model.mudidi1;

import com.google.gson.annotations.Expose;

public class Header {

    @Expose
    private String rspType;
    @Expose
    private String rspCode;
    @Expose
    private String rspDesc;

    /**
     * 
     * @return
     *     The rspType
     */
    public String getRspType() {
        return rspType;
    }

    /**
     * 
     * @param rspType
     *     The rspType
     */
    public void setRspType(String rspType) {
        this.rspType = rspType;
    }

    /**
     * 
     * @return
     *     The rspCode
     */
    public String getRspCode() {
        return rspCode;
    }

    /**
     * 
     * @param rspCode
     *     The rspCode
     */
    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
    }

    /**
     * 
     * @return
     *     The rspDesc
     */
    public String getRspDesc() {
        return rspDesc;
    }

    /**
     * 
     * @param rspDesc
     *     The rspDesc
     */
    public void setRspDesc(String rspDesc) {
        this.rspDesc = rspDesc;
    }

}
