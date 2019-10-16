package com.pprokurat.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pprokurat.api.model.Folder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static List<Folder> folders;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String[] args) throws IOException {

        folders = new ArrayList<Folder>();

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readValue(new File("data.json"), JsonNode.class);

        Iterator<Map.Entry<String,JsonNode>> iterator = jsonNode.fields();

        while(iterator.hasNext()){
            Map.Entry<String, JsonNode> currentIterator = iterator.next();
            String key = currentIterator.getKey();
            Folder folder = objectMapper.readValue(currentIterator.getValue().toString(),Folder.class);
            folder.setPath(key);
            folders.add(folder);
        }

    }

    public static List<Folder> getFolders() {
        return folders;
    }

}
