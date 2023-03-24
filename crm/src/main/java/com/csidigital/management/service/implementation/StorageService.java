package com.csidigital.management.service.implementation;


import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

@Service
public class StorageService {
    private final Path rootLocation = Paths.get("upload-dir");

    public StorageService() {
        init();
    }
    public String store(MultipartFile file) {
        try {
            System.out.println(rootLocation);
            String fileName = Integer.toString(new Random().nextInt(1000000000));
            System.out.println(fileName);
            String ext = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf('.'), file.getOriginalFilename().length());
            System.out.println(ext);
            String name  = file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf('.'));
            System.out.println(name);
            String original = name + fileName + ext;
            System.out.println(original);
            Path filePath = this.rootLocation.resolve(original);
            System.out.println(filePath);
            if(file.isEmpty()) {
                throw new RuntimeException("File is empty!");
            }
            Files.copy(file.getInputStream(),filePath);
            return filePath.toUri().toString();
        } catch (Exception e) {
            System.err.println("Error storing file: " + e.getMessage());
            throw new RuntimeException("Error storing file: " + e.getMessage());
        }
    }



    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }


    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {
        try {
            if (!Files.exists(rootLocation)) {
                Files.createDirectory(rootLocation);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
}
