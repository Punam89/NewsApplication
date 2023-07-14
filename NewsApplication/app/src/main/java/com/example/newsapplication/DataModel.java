package com.example.newsapplication;

import java.util.ArrayList;

public class DataModel {

    private  String status;
    private  String totalResults;
    private ArrayList<HeadingDataModel>  articles;

    public DataModel(String status, String totalResults, ArrayList<HeadingDataModel> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<HeadingDataModel> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<HeadingDataModel> articles) {
        this.articles = articles;
    }
}
