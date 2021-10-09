package ru.job4j.fileSearch;
/**2. Поиск файлов по критерию [#783]02*/

import ru.job4j.io.ArgsName;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
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
        File path = new File("./", nameFile);
        searchFile.choice(typeFound, file, path, fullNameMatchFile, searchFile);
    }

    private void choice(String typeFound, Path file, File path, String fullNameMatchFile, SearchFile searchFile) {
        if (typeFound.equals("name")) {
            searchFilePre(file, path, fullNameMatchFile, null, searchFile);
        } else if (typeFound.equals("mask")) {
            Pattern pat = Pattern.compile(fullNameMatchFile.replace("*", ".*").replace("?", "\\w{1}"));
            searchFilePre(file, path, fullNameMatchFile, pat, searchFile);
        } else if (typeFound.equals("regex")) {
            Pattern pat = Pattern.compile(fullNameMatchFile);
            searchFilePre(file, path, fullNameMatchFile, pat, searchFile);
        }
    }

    private void searchFilePre(Path file, File path, String fullNameMatchFile, Pattern pat, SearchFile searchFile) {
        if (pat.equals(null)) {
            try {
                List<Path> list = search(file, path1 -> path1.toFile().getName().equals(fullNameMatchFile));
                searchFile.writeFile(path, list);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                List<Path> list = search(file, path1 -> pat.matcher(path1.toFile().getName()).matches());
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
                out.println(p.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}