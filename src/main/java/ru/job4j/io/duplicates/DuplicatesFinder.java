package ru.job4j.io.duplicates;
//4.2. Поиск дубликатов [#315066]
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {

    public static void main(String[] args) throws IOException {
        DuplicatesVisitor temp = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), temp);
        temp.getArrayList().stream().forEach(fileProperty -> System.out.println(fileProperty.getName() + " " + fileProperty.getSize()));
    }
}
