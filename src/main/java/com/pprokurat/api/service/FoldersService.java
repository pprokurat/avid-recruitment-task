package com.pprokurat.api.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pprokurat.api.model.Folder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Iterator;

import static com.pprokurat.api.Application.folders;

@Service
public class FoldersService {

    /**
     *
     * @return folder list as target JSON
     * @throws IOException
     */
    public JsonNode getFoldersList() throws IOException {
        String resultsString = "{\"results\":[";

        Iterator<Folder> iterator = folders.iterator();

        //add folders' IDs and paths to the string using Folder class toResultString() method
        while(iterator.hasNext()){
            Folder folder = iterator.next();

            if(!iterator.hasNext()){
                resultsString = resultsString.concat(folder.toResultString());
                break;
            }
            else{
                resultsString = resultsString.concat(folder.toResultString()+",");
            }
        }

        resultsString = resultsString.concat("]}");

        //map result string to target JSON
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode results = objectMapper.readTree(resultsString);

        return results;
    }

    /**
     *
     * @param folderId
     * @return particular folder object from the list (by ID)
     */
    public Folder getFolderById(Integer folderId) {
        Folder targetFolder = new Folder();
        for (Folder folder : folders) {
            if (folderId.equals(folder.getId())) {
                targetFolder = folder;
                break;
            }
        }
        return targetFolder;
    }

}
