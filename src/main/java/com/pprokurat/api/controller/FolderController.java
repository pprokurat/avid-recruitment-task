package com.pprokurat.api.controller;

import com.pprokurat.api.dto.FolderDto;
import com.pprokurat.api.exception.FolderNotFoundException;
import com.pprokurat.api.model.Folder;
import com.pprokurat.api.service.FolderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class FolderController {

    private final FolderService service;

    public FolderController(FolderService service) {
        this.service = service;
    }

    /**
     * @return list of all folders at "/" endpoint at GET request
     */
    @RequestMapping(name = "/", method = GET)
    public List<FolderDto> returnFoldersList() {
        return service.getFoldersList();
    }

    /**
     * @param folderId at "/{folderId}" endpoint at GET request
     * @return folder data by ID at "/{folderId}" endpoint at GET request
     */
    @RequestMapping(value = "/{folderId}", method = GET)
    public Folder returnFolderById(@PathVariable("folderId") Integer folderId) {

        Folder targetFolder = service.getFolderById(folderId);

        if (targetFolder == null) {
            throw new FolderNotFoundException();
        } else {
            return targetFolder;
        }
    }

}
