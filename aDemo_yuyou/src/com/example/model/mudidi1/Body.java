package com.example.model.mudidi1;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Body {

    @Expose
    private List<CategoryList> categoryList = new ArrayList<CategoryList>();
    @Expose
    private String defaultCategoryId;

    /**
     * 
     * @return
     *     The categoryList
     */
    public List<CategoryList> getCategoryList() {
        return categoryList;
    }

    /**
     * 
     * @param categoryList
     *     The categoryList
     */
    public void setCategoryList(List<CategoryList> categoryList) {
        this.categoryList = categoryList;
    }

    /**
     * 
     * @return
     *     The defaultCategoryId
     */
    public String getDefaultCategoryId() {
        return defaultCategoryId;
    }

    /**
     * 
     * @param defaultCategoryId
     *     The defaultCategoryId
     */
    public void setDefaultCategoryId(String defaultCategoryId) {
        this.defaultCategoryId = defaultCategoryId;
    }

}
