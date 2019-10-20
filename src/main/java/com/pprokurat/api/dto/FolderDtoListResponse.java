package com.pprokurat.api.dto;

import java.util.ArrayList;
import java.util.List;

public class FolderDtoListResponse {
    private List<FolderDto> results = new ArrayList<>();

    public FolderDtoListResponse(List<FolderDto> results) {
        this.results.addAll(results);
    }

    public List<FolderDto> getResults() {
        return results;
    }
}
