package ru.job4j.io;
//5.2. Архивировать проект [#861]
import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static ru.job4j.io.Search.search;

public class Zip {
    public static void packFiles(List<Path> sources, Path target) {
        if (sources.isEmpty()) {
            throw new IllegalArgumentException();
        }
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
        //String fileoutput =  "/home/denis/IdeaProjects/job4j_design/test/test.zip";
        //String fileoutput = "/home/extrausa/IdeaProjects/job4j_design/test/test.zip";
        //String fileinput = "/home/extrausa/IdeaProjects/job4j_design/";
        //String fileinput = "/home/denis/IdeaProjects/job4j_design";
        //Path start = Paths.get(fileinput);
        //Path path = Paths.get(fileoutput);
        //File file = new File(fileoutput);
//        List<Path> sources = new ArrayList<>();
//        search(start, path1 -> path1.toFile().getName().endsWith(".js"));
//        sources.add(start);
//        Scanner in;
//        String fileinput = null;
//        String exclude = null;
//        String fileNameZip = null;
//        for (int i = 0; i < 3; i++) {
//            in = new Scanner(System.in);
//            if (i == 0) {
//                System.out.print("-d=");
//                fileinput = "-d=" + "" + in.next();
//            } else if (i == 1) {
//                in = new Scanner(System.in);
//                System.out.print("-e=");
//                exclude ="-e=" + "" + in.next();
//            } else {
//                in = new Scanner(System.in);
//                System.out.print("-o=");
//                fileNameZip = "-o=" + "" + in.next();
//            }
//        }
        //ArgsName argsName = ArgsName.of(new String[]{fileinput, exclude, fileNameZip});
        if (args.length != 2) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        ArgsName argsName = ArgsName.of(args);
        Path start =  Paths.get(argsName.get("d"));
        Path path = Paths.get(argsName.get("o"));
        packFiles(search(start, path1 -> !path1.toFile().getName().endsWith(argsName.get("e"))), path);
    }
}
