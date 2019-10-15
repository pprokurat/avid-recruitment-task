package com.pprokurat.api.model;

public class MediaItem {

    private String essenceType;
    private String filePath;
    private String track;
    private int start;
    private int length;
    private String mobId;
    private boolean online;
    private String type;

    public String getEssenceType() {
        return essenceType;
    }

    public void setEssenceType(String essenceType) {
        this.essenceType = essenceType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getMobId() {
        return mobId;
    }

    public void setMobId(String mobId) {
        this.mobId = mobId;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
