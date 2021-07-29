package ru.job4j.io;
//5.2. Архивировать проект [#861]
import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static ru.job4j.io.Search.search;

public class Zip {
    public static void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toFile())))) {
            for (Path p : sources) {
                zip.putNextEntry(new ZipEntry(p.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(p.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static void main(String[] args) throws IOException {
//        packSingleFile(
//                new File("/home/extrausa/IdeaProjects/job4j_design/test/pom.xml"),
//                new File("/home/extrausa/IdeaProjects/job4j_design/test/pom.zip")
//        );
        //String filename =  "/home/denis/IdeaProjects/job4j_design/test";
        String fileoutput = "/home/extrausa/IdeaProjects/job4j_design/test/test.zip";
        String fileinput = "/home/extrausa/IdeaProjects/job4j_design/";
        Path start = Paths.get(fileinput);
        Path path = Paths.get(fileoutput);
        File file = new File(fileoutput);
//        List<Path> sources = new ArrayList<>();
//        search(start, path1 -> path1.toFile().getName().endsWith(".js"));
//        sources.add(start);
        packFiles(search(start, path1 -> path1.toFile().getName().endsWith(".js")), path);
    }
}
