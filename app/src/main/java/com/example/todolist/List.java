package com.example.todolist;

import android.text.SpannableString;

import java.util.ArrayList;

public class List {
    private String name;
    private ArrayList<SpannableString> itemList;
    private int size;

    public List(ArrayList<SpannableString> itemList, String name){
        this.name = name;
        this.itemList = itemList;
        size = itemList.size();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemList(ArrayList<SpannableString> itemList) {
        this.itemList = itemList;
    }

    public ArrayList<SpannableString> getItemList() {
        return itemList;
    }


    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}
