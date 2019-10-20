package com.pprokurat.api.service;

import com.pprokurat.api.data.FolderRepository;
import com.pprokurat.api.data.ResourceConfiguration;
import com.pprokurat.api.dto.FolderDto;
import com.pprokurat.api.model.Folder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderService {

    private FolderRepository folderRepository = new FolderRepository(new ResourceConfiguration());

    /**
     *
     * @return list of folders (ID and path only)
     */
    public List<FolderDto> getFoldersList() {
        return folderRepository.getTransferFoldersList();
    }

    /**
     *
     * @param folderId folder ID
     * @return particular folder object from the list (by ID)
     */
    public Folder getFolderById(Integer folderId) {
        return folderRepository.findFolderById(folderId);
    }

}
