package com.pprokurat.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Folder {

    private int id;
    private String path;

    private List<Asset> assets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }


    public String toResultString() {
        return "{" +
                "\"id\":" + id +
                ",\"path\":\"" + path +
                "\"}";
    }
}
