package com.pprokurat.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Asset {

    private List<Attribute> attributes;
    private Base base;

    @JsonProperty("media-items")
    private List<MediaItem> mediaItems;
    private Common common;
    private String mobId;

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public List<MediaItem> getMediaItems() {
        return mediaItems;
    }

    public void setMediaItems(List<MediaItem> mediaItems) {
        this.mediaItems = mediaItems;
    }

    public Common getCommon() {
        return common;
    }

    public void setCommon(Common common) {
        this.common = common;
    }

    public String getMobId() {
        return mobId;
    }

    public void setMobId(String mobId) {
        this.mobId = mobId;
    }

}
