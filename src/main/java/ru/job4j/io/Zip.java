package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static void packFiles(List<File> sources, File target) {


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

        String filename = "/home/extrausa/IdeaProjects/job4j_design/test";
//        if (args.length == 0) {
//            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
//        }
//        File file = new File(args[0]);
        packSingleFile(
                new File("/home/extrausa/IdeaProjects/job4j_design/test/pom.xml"),
                new File("/home/extrausa/IdeaProjects/job4j_design/test/pom.zip")
        );
        //packFiles();
    }
}
