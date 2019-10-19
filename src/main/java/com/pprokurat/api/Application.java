package com.pprokurat.api;

import com.pprokurat.api.data.FolderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static FolderRepository folderRepository = new FolderRepository();

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    /**
     * after running the application load folders data from JSON file into a list of folder objects
     * @param args
     * @throws IOException
     */
    @Override
    public void run(String[] args) throws IOException {

        folderRepository.loadData();

    }

}
