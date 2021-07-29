package ru.job4j.io;
//5.2. Архивировать проект [#861]
import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static void packFiles(List<Path> sources, File target) {



    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        packSingleFile(
//                new File("/home/extrausa/IdeaProjects/job4j_design/test/pom.xml"),
//                new File("/home/extrausa/IdeaProjects/job4j_design/test/pom.zip")
//        );
        //String filename = "/home/extrausa/IdeaProjects/job4j_design/test";
        String filename =  "/home/denis/IdeaProjects/job4j_design/test";
        Search searchFile = new Search();


        //packFiles();
    }
}