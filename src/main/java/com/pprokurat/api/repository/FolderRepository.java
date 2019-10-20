package com.pprokurat.api.repository;

import com.pprokurat.api.model.Folder;

import java.util.List;

public interface FolderRepository {

    List<Folder> getAll();

    Folder getOneById(Integer id);

}
