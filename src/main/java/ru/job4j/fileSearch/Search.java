package ru.job4j.fileSearch;
//2. Поиск файлов по критерию [#783]02

import ru.job4j.io.ArgsName;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Search {
    public static void main(String[] args) {
        Search search = new Search();
        String directoryLog = ("/home/denis/IdeaProjects/job4j_design/test");
        if (args.length != 4) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        ArgsName argsName = ArgsName.of(args);
        File file = new File(argsName.get("d"));
        String fullNameMatchFile = (argsName.get("n"));
        String nameFile = (argsName.get("o"));
        String typeFound = (argsName.get("t"));
        if (typeFound.equals("nameFile")) {
            search.findFile(fullNameMatchFile, file, directoryLog, nameFile);
        }
    }

    private void findFile(String fullNameMatchFile, File file, String directoryLog, String nameLogFile) {
        File[] listFile = file.listFiles();
        if (listFile != null) {
            for (File subfile : file.listFiles()) {
                if (subfile.isDirectory()) {
                    findFile(fullNameMatchFile, subfile, directoryLog, nameLogFile);
                } else if (fullNameMatchFile.equalsIgnoreCase(subfile.getName())) {
                    System.out.println("Yes");
                    writeFile(directoryLog, subfile, nameLogFile);
                }
            }
        }
    }

    private void writeFile(String directoryLog, File subfile, String nameFile) {
        File directoryLogFile = new File(directoryLog, nameFile);
        byte[] bufAbsolutAdress = (subfile.getAbsolutePath() + System.lineSeparator()).getBytes(StandardCharsets.UTF_8);
        if (!directoryLogFile.exists()) {
            try (FileOutputStream file = new FileOutputStream(directoryLogFile)) {
                directoryLogFile.createNewFile();
                file.write(bufAbsolutAdress);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (FileOutputStream file = new FileOutputStream(directoryLogFile, true)) {
                file.write(bufAbsolutAdress);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
