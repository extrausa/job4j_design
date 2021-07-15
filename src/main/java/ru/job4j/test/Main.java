package ru.job4j.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("/home/extrausa/IdeaProjects/job4j_design/test/");
        Files.walkFileTree(p, new MyFileVisitor());
    }
}
