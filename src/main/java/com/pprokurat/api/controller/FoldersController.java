package com.pprokurat.api.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.pprokurat.api.model.Folder;
import com.pprokurat.api.service.FoldersService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class FoldersController {

    private final FoldersService service;

    public FoldersController(FoldersService service) {
        this.service = service;
    }

    /**
     *
     * @return list of all folders at "/" endpoint at GET request
     * @throws IOException
     */
    @RequestMapping(name="/", method = GET)
    public JsonNode returnFoldersList() throws IOException {
        return service.getFoldersList();
    }

    /**
     *
     * @param folderId at "/{folderId}" endpoint at GET request
     * @return folder data by ID at "/{folderId}" endpoint at GET request
     */
    @RequestMapping(value="/{folderId}", method = GET)
    public Folder returnFolderById(@PathVariable("folderId") Integer folderId) {
        return service.getFolderById(folderId);
    }

}
