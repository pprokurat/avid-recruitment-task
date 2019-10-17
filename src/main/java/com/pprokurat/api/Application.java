package com.pprokurat.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pprokurat.api.model.Folder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static List<Folder> folders;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    //after running application load folders data from JSON file into a list of folder objects
    @Override
    public void run(String[] args) throws IOException {

        folders = new ArrayList<Folder>();

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
                folders.add(folder);
            }
        }

    }

    //return the folder list as target JSON
    public static JsonNode getFoldersList() throws IOException {
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

    //return particular folder object from the list (by ID)
    public static Folder getFolderById(Integer folderId) {
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
