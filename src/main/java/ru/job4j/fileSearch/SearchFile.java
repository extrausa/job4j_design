package ru.job4j.fileSearch;
//2. Поиск файлов по критерию [#783]02

import ru.job4j.io.ArgsName;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.regex.Pattern;

import static ru.job4j.io.Search.search;

public class SearchFile {
    public static void main(String[] args) {
        SearchFile searchFile = new SearchFile();
//        searchFile.validation(args);
//        ArgsName argsName = ArgsName.of(args);
//        Path file = Paths.get(argsName.get("d"));
//        String fullNameMatchFile = (argsName.get("n"));
//        String nameFile = (argsName.get("o"));
//        String typeFound = (argsName.get("t"));
//        File path = new File("./test", nameFile);
        Path file = Paths.get("/home/denis/IdeaProjects/job4j_design");
        String fullNameMatchFile = ("*some?file.doc?");
        String nameFile = ("log.txt");
        String typeFound = ("regex");
        File path = new File("/home/denis/IdeaProjects/job4j_design/test", nameFile);
        searchFile.choice(typeFound, file, path, fullNameMatchFile, searchFile);

    }

    private void choice(String typeFound, Path file, File path, String fullNameMatchFile, SearchFile searchFile) {
        if (typeFound.equals("name")) {
            try {
                List<Path> list = search(file, path1 -> path1.toFile().getName().equals(fullNameMatchFile));
                searchFile.writeFile(path, list);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (typeFound.equals("mask")) {
            Pattern pat = Pattern.compile(fullNameMatchFile);
            //String[] nameDot = fullNameMatchFile.split("\\.(?=[^\\.]+$)");
            try {
                List<Path> list = search(file, path1 -> path1.toFile().getName().);
                searchFile.writeFile(path, list);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (typeFound.equals("regex")) {
            try {
                List<Path> list = search(file, path1 -> path1.toFile().getName().matches(fullNameMatchFile));
                searchFile.writeFile(path, list);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void validation(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
    }

    private void writeFile(File directoryLog, List<Path> list) {
        if (!directoryLog.exists()) {
            try {
                directoryLog.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (PrintWriter out = new PrintWriter(new FileWriter(directoryLog, true))) {
            for (Path p : list) {
                out.write(p.toString());
                out.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
