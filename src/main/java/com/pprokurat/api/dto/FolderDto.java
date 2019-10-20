package com.pprokurat.api.dto;

public class FolderDto {

    private int id;
    private String path;

    public FolderDto(int id, String path) {
        this.id = id;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public String getPath() {
        return path;
    }
}