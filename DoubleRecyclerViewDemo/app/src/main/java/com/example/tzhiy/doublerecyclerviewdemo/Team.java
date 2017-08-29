package com.example.tzhiy.doublerecyclerviewdemo;

/**
 * Created by tzhiy on 2017/7/16.
 */

public class Team {
    private String name;
    private String imagePath;;

    public Team(String name,String imagePath){
        this.name =name;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
