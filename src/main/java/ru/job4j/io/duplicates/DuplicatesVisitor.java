package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    FileProperty fileProp;
    //HashMap<Long, String> map = new HashMap<>();
    List<FileProperty> arrayList = new ArrayList<>();
    Set<FileProperty>  setRepiat = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        fileProp = new FileProperty(path.toFile().length(), path.toFile().getName());
        if (!setRepiat.contains(fileProp)) {
            setRepiat.add(fileProp);
        } else {
            arrayList.add(fileProp);
        }
        return super.visitFile(path, attrs);
    }

    public List<FileProperty> getArrayList() {
        return arrayList;
    }
}
