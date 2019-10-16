package com.pprokurat.api.controllers;

import com.pprokurat.api.Application;
import com.pprokurat.api.model.Folder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class FoldersController {

    @RequestMapping(name="/", method = GET)
    public List<Folder> folders() {
        return Application.getFolders();
    }

}
