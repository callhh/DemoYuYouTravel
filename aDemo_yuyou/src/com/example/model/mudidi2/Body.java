package com.example.model.mudidi2;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Body {

    @Expose
    private List<GroupList> groupList = new ArrayList<GroupList>();

    /**
     * 
     * @return
     *     The groupList
     */
    public List<GroupList> getGroupList() {
        return groupList;
    }

    /**
     * 
     * @param groupList
     *     The groupList
     */
    public void setGroupList(List<GroupList> groupList) {
        this.groupList = groupList;
    }

}
