package com.example.brom.listviewjsonapp;

/**
 * Created by a17johpe on 2018-04-17.
 */

public class Mountain {
    private int ID;
    private String name;
    private String type;
    private String company;
    private String location;
    private String category;
    private int size;
    private int cost;
    private String imgUrl;
    private String infoUrl;

    public Mountain(int inID, String inName, String inType, String inCompany, String inLocation, String inCategory, int inSize, int inCost, String inImgUrl, String inInfoUrl){
        ID = inID;
        name = inName;
        type = inType;
        company = inCompany;
        location = inLocation;
        category = inCategory;
        size = inSize;
        cost = inCost;
        imgUrl = inImgUrl;
        infoUrl = inInfoUrl;
    }

    public String info() {
        String str="Mountain: " + name + "\n" + "Location: " + location + "\n" + "Height: " + size + " m";
        return str;
    }

    public String nameInfo() {
        return name;
    }

    public String locationInfo() {
        return location;
    }

    public int heightInfo() {
        return size;
    }

    @Override
    public String toString() {
        return name;
    }
}
