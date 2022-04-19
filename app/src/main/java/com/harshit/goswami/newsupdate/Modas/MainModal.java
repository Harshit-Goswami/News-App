package com.harshit.goswami.newsupdate.Modas;

import java.util.ArrayList;

public class MainModal {
    String status,totalResults;
    ArrayList<ItemModal> articles;

    public MainModal(String status, String totalResults, ArrayList<ItemModal> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public ArrayList<ItemModal> getArticles() {
        return articles;
    }
}
