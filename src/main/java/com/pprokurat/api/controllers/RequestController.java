package com.pprokurat.api.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.pprokurat.api.Application;
import com.pprokurat.api.model.Folder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RequestController {

    //return list of all folders at "/" endpoint at GET request
    @RequestMapping(name="/", method = GET)
    public JsonNode returnFolders() throws IOException {
        return Application.getFolders();
    }

    //return folder data by ID at "/{folderId}" endpoint at GET request
    @RequestMapping(value="/{folderId}", method = GET)
    public Folder returnFolderById(@PathVariable("folderId") Integer folderId) {
        return Application.getFolderById(folderId);
    }

}
