package com.example.gambm.gitsearch;

import java.util.ArrayList;

public class ReposInfo {

    private ArrayList<Login> items = new ArrayList<>();

    public void setList(ArrayList<Login> items) {
        this.items = items;
    }

    public ArrayList<Login> getList() {
        return items;
    }
}
