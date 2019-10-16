package com.pprokurat.api.controllers;

import com.pprokurat.api.Application;
import com.pprokurat.api.model.Folder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class FoldersController {

    //return list of all folders at "/" endpoint at GET request
    @RequestMapping(name="/", method = GET)
    public List<Folder> returnFolders() {
        return Application.getFolders();
    }

    //return folder data by ID at "/{folderId}" endpoint at GET request
    @RequestMapping(value="/{folderId}", method = GET)
    public Folder returnFolderById(@PathVariable("folderId") Integer id) {
        return Application.getFolderById(id);
    }

}
