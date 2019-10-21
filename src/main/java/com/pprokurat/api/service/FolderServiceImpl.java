package com.pprokurat.api.service;

import com.pprokurat.api.dto.FolderDto;
import com.pprokurat.api.model.Folder;
import com.pprokurat.api.repository.FolderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class FolderServiceImpl implements FolderService {

    private final FolderRepository folderRepository;

    public FolderServiceImpl(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    /**
     * @return list of folders (ID and path only)
     */
    @Override
    public List<FolderDto> getFoldersList() {

        List<Folder> foldersList = folderRepository.getAll();
        List<FolderDto> targetFoldersDtoList = new ArrayList<>();

        for (Folder folder : foldersList) {

            FolderDto dto = new FolderDto(folder.getId(), folder.getPath());

            targetFoldersDtoList.add(dto);
        }

        targetFoldersDtoList.sort(new SortById());

        return targetFoldersDtoList;
    }

    /**
     * @param folderId - particular folder ID
     * @return particular folder object from the list (by ID)
     */
    @Override
    public Folder getFolderById(Integer folderId) {
        return folderRepository.getOneById(folderId);
    }

}

/**
 * sort folders by ID in ascending order
 */
class SortById implements Comparator<FolderDto> {

    public int compare(FolderDto a, FolderDto b) {
        return a.getId() - b.getId();
    }
}
