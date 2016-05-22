package com.example.model.header2.kuaileduantu;

import com.google.gson.annotations.Expose;

public class PageInfo {

    @Expose
    private String page;
    @Expose
    private String pageSize;
    @Expose
    private String totalPage;
    @Expose
    private String totalCount;

    /**
     * 
     * @return
     *     The page
     */
    public String getPage() {
        return page;
    }

    /**
     * 
     * @param page
     *     The page
     */
    public void setPage(String page) {
        this.page = page;
    }

    /**
     * 
     * @return
     *     The pageSize
     */
    public String getPageSize() {
        return pageSize;
    }

    /**
     * 
     * @param pageSize
     *     The pageSize
     */
    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 
     * @return
     *     The totalPage
     */
    public String getTotalPage() {
        return totalPage;
    }

    /**
     * 
     * @param totalPage
     *     The totalPage
     */
    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * 
     * @return
     *     The totalCount
     */
    public String getTotalCount() {
        return totalCount;
    }

    /**
     * 
     * @param totalCount
     *     The totalCount
     */
    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

}
