package com.example.model.header1;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Bottom {

    @Expose
    private String backgroundColor;
    @Expose
    private String topLineColor;
    @Expose
    private List<MenuList> menuList = new ArrayList<MenuList>();

    /**
     * 
     * @return
     *     The backgroundColor
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * 
     * @param backgroundColor
     *     The backgroundColor
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * 
     * @return
     *     The topLineColor
     */
    public String getTopLineColor() {
        return topLineColor;
    }

    /**
     * 
     * @param topLineColor
     *     The topLineColor
     */
    public void setTopLineColor(String topLineColor) {
        this.topLineColor = topLineColor;
    }

    /**
     * 
     * @return
     *     The menuList
     */
    public List<MenuList> getMenuList() {
        return menuList;
    }

    /**
     * 
     * @param menuList
     *     The menuList
     */
    public void setMenuList(List<MenuList> menuList) {
        this.menuList = menuList;
    }

}
