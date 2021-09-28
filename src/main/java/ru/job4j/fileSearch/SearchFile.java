package ru.job4j.fileSearch;
//2. Поиск файлов по критерию [#783]02

import ru.job4j.io.ArgsName;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static ru.job4j.io.Search.search;

public class SearchFile {
    public static void main(String[] args) {
        SearchFile searchFile = new SearchFile();
        searchFile.validation(args);
        ArgsName argsName = ArgsName.of(args);
        Path file = Paths.get(argsName.get("d"));
        String fullNameMatchFile = (argsName.get("n"));
        String nameFile = (argsName.get("o"));
        String typeFound = (argsName.get("t"));
        File path = new File("./test", nameFile);

        if (!path.exists()) {
            try {
                path.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (typeFound.equals("name")) {
            try {
                 List<Path> list = search(file, path1 -> path1.toFile().getName().equals(fullNameMatchFile));
                if (!list.isEmpty()) {
                    for (Path p : list) {
                        searchFile.writeFile(path, p.toFile());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (typeFound.equals("mask")) {
            String[] nameDot = fullNameMatchFile.split("\\.(?=[^\\.]+$)");
            try {
                List<Path> list = search(file, path1 -> path1.toFile().getName().endsWith(nameDot[1]));
                if (!list.isEmpty()) {
                    for (Path p : list) {
                        searchFile.writeFile(path, p.toFile());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (typeFound.equals("regex")) {
            try {
                List<Path> list = search(file, path1 -> path1.toFile().getName().matches(fullNameMatchFile));
                if (!list.isEmpty()) {
                    for (Path p : list) {
                        searchFile.writeFile(path, p.toFile());
                    }
                }
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

    private void writeFile(File directoryLog, File subfile) {
        byte[] bufAbsolutAdress = (subfile.getAbsolutePath() + System.lineSeparator()).getBytes(StandardCharsets.UTF_8);
        try (FileOutputStream file = new FileOutputStream(directoryLog, true)) {
                file.write(bufAbsolutAdress);
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
}
