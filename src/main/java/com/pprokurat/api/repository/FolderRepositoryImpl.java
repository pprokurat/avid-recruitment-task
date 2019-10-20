package com.pprokurat.api.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pprokurat.api.dto.FolderDto;
import com.pprokurat.api.model.Folder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public class FolderRepositoryImpl implements FolderRepository {

    private final ResourceConfiguration configuration;
    private static final List<Folder> foldersList = new ArrayList<>();

    public FolderRepositoryImpl(ResourceConfiguration configuration) {
        this.configuration = configuration;
    }

    /**
     * load data from JSON file into list of folder objects
     */
    @PostConstruct
    public void init() {

        ObjectMapper objectMapper = new ObjectMapper();
        File inputFile = getFileFromResources(configuration.getFilename());

        try (FileInputStream fis = new FileInputStream(inputFile)) {
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
        catch (IOException e) {
            System.out.println("Error: cannot read folder data file");
        }


    }

    @Override
    public List<FolderDto> getAll() {

        List<FolderDto> targetFoldersList = new ArrayList<>();

        Iterator<Folder> iterator = foldersList.iterator();

        while(iterator.hasNext()){
            Folder folder = iterator.next();
            FolderDto dto = new FolderDto();

            dto.setId(folder.getId());
            dto.setPath(folder.getPath());

            targetFoldersList.add(dto);
        }

        Collections.sort(targetFoldersList, new SortById());

        return targetFoldersList;
    }

    @Override
    public Folder getOneById(Integer folderId) {
        Folder targetFolder = new Folder();
        targetFolder.setId(-1);

        Iterator<Folder> iterator = foldersList.iterator();

        while(iterator.hasNext()){
            Folder folder = iterator.next();

            if(folderId.equals(folder.getId())){
                targetFolder = folder;
                break;
            }
        }

        return targetFolder;
    }

    private File getFileFromResources(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("Error: file not found");
        } else {
            return new File(resource.getFile());
        }

    }

}

class SortById implements Comparator<FolderDto> {

    public int compare(FolderDto a, FolderDto b) {
        return a.getId()-b.getId();
    }
}
