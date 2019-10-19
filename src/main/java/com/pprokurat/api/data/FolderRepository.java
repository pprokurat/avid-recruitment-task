package com.pprokurat.api.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pprokurat.api.model.Folder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FolderRepository {

    private List<Folder> foldersList;

    /**
     * load data from JSON file into list of folder objects
     * @throws IOException
     */
    public void loadData() throws IOException {

        foldersList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File inputFile = new File("data.json");
        FileInputStream fis = new FileInputStream(inputFile);
        int iByteCount = fis.read();

        //populate the folders list only if the input file is not empty
        if(!(iByteCount == -1)){
            JsonNode jsonNode = objectMapper.readValue(inputFile, JsonNode.class);
            Iterator<Map.Entry<String,JsonNode>> iterator = jsonNode.fields();

            while(iterator.hasNext()){
                Map.Entry<String, JsonNode> currentIterator = iterator.next();
                String key = currentIterator.getKey();
                Folder folder = objectMapper.readValue(currentIterator.getValue().toString(),Folder.class);
                folder.setPath(key);
                foldersList.add(folder);
            }
        }

    }

    public List<Folder> getFoldersList() {
        return foldersList;
    }

}
