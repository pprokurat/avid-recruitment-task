package com.pprokurat.api.service;

import com.pprokurat.api.dto.FolderDto;
import com.pprokurat.api.exception.FolderNotFoundException;
import com.pprokurat.api.model.Folder;

import java.util.List;

public interface FolderService {

    List<FolderDto> getFoldersList() throws FolderNotFoundException;

    Folder getFolderById(Integer folderId) throws FolderNotFoundException;

}
