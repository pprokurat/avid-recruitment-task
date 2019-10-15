package com.pprokurat.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Folder {

    private int id;
    private List<Asset> assets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

}
