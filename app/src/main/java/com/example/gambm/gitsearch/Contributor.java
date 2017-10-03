package com.example.gambm.gitsearch;

public class Contributor {

    private String login, html_url;
    private int contributions;

    @Override
    public String toString() {
        return login + " (" + contributions + ")";
    }
}
