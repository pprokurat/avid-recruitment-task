package com.pprokurat.api.repository;

import com.pprokurat.api.dto.FolderDto;
import com.pprokurat.api.model.Folder;

import java.util.List;

public interface FolderRepository {

    List<FolderDto> getAll();

    Folder getOneById(Integer id);

}
