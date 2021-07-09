package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFiles implements FileVisitor<Path> {
    List<Path> temp;
    Predicate<Path> rest;
    Path pa;

    public SearchFiles(Predicate<Path> condition) {
        temp = new ArrayList<>();
        rest = condition;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        return null;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
//        if (path.toAbsolutePath() {
//            temp.add(path.toAbsolutePath());
//            //System.out.println(path.toAbsolutePath());
//        }
        if (path.getFileName().toString().endsWith(basicFileAttributes.)) {
            temp.add(path.toAbsolutePath());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path path, IOException e) throws IOException {
        return null;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path path, IOException e) throws IOException {
        return null;
    }

    public List<Path> getPaths() {
        return temp;
    }
}
