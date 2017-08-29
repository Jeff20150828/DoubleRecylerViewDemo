package com.example.tzhiy.doublerecyclerviewdemo;

import java.util.List;

/**
 * Created by tzhiy on 2017/7/16.
 */

public class Category {

    private String categoryName;
    private boolean isSelected;
    private List<Team> teams;

    public Category(String categoryName,List<Team>teams){
        this.categoryName = categoryName;
        this.teams = teams;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> items) {
        this.teams = items;
    }
}
