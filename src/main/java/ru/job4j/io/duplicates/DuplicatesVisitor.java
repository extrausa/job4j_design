package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    FileProperty fileProp;
    HashMap<Long, String> map = new HashMap<>();
    List<String> arrayList = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        fileProp = new FileProperty(path.toFile().length(), path.toFile().getName());

        if (map.size() != 0 && map.containsKey(fileProp.getSize()) && map.containsValue(fileProp.getName())) {
            arrayList.add(fileProp.getName());
        }
        map.put(fileProp.getSize(), fileProp.getName());
        return super.visitFile(path, attrs);
    }

    public List<String> getArrayList() {
        return arrayList;
    }
}
