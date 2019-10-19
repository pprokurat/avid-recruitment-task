package com.pprokurat.api.service;

import com.pprokurat.api.dto.FolderDto;
import com.pprokurat.api.model.Folder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.pprokurat.api.Application.folderRepository;

@Service
public class FolderService {

    /**
     *
     * @return list of folders (ID and path only)
     */
    public List<FolderDto> getFoldersList() {

        List<FolderDto> targetFoldersList = new ArrayList<>();

        Iterator<Folder> iterator = folderRepository.getFoldersList().iterator();

        while(iterator.hasNext()){
            Folder folder = iterator.next();
            FolderDto dto = new FolderDto();

            dto.setId(folder.getId());
            dto.setPath(folder.getPath());

            targetFoldersList.add(dto);
        }

        return targetFoldersList;
    }

    /**
     *
     * @param folderId
     * @return particular folder object from the list (by ID)
     */
    public Folder getFolderById(Integer folderId) {
        Folder targetFolder = new Folder();

        Iterator<Folder> iterator = folderRepository.getFoldersList().iterator();

        while(iterator.hasNext()){
            Folder folder = iterator.next();

            if(folderId.equals(folder.getId())){
                targetFolder = folder;
                break;
            }
        }

        return targetFolder;
    }

}