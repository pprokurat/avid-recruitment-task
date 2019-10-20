package com.pprokurat.api.service;

import com.pprokurat.api.repository.FolderRepository;
import com.pprokurat.api.dto.FolderDto;
import com.pprokurat.api.exception.FolderNotFoundException;
import com.pprokurat.api.model.Folder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderServiceImpl implements FolderService {

    private final FolderRepository folderRepository;

    public FolderServiceImpl(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    /**
     *
     * @return list of folders (ID and path only)
     */
    @Override
    public List<FolderDto> getFoldersList() throws FolderNotFoundException {
        return folderRepository.getAll();
    }

    /**
     *
     * @param folderId folder ID
     * @return particular folder object from the list (by ID)
     */
    @Override
    public Folder getFolderById(Integer folderId) throws FolderNotFoundException {
        return folderRepository.getOneById(folderId);
    }

}
