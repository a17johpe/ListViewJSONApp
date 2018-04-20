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
    private String auxdata;

    public Mountain(String inName){
        //ID = inID;
        name = inName;
        //type = inType;
        //company = inCompany;
        //location = inLocation;
        //category = inCategory;
        //size = inSize;
        //cost = inCost;
        //auxdata = inAuxdata;
    }

    public String info() {
        String str=name + location + size;
        //str += "is a mountain.";
        return str;
    }

    @Override
    public String toString() {
        return name;
    }
}
