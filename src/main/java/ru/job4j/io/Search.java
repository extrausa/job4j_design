package ru.job4j.io;
/**5. Валидация параметров запуска. [#246865]*/
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        File file = new File(args[0]);
        Path start = file.toPath();
        /**Path start = Paths.get("/home/extrausa/IdeaProjects/job4j_design/");*/
        Scanner in = new Scanner(System.in);
        System.out.print("Введите искомые расширения(js, txt ....): ");
        String name = in.next();
        if (in.hasNextLine()) {
            System.out.println("файлы с расширением" + " " + name + " " + "Найдены");
            search(start, p -> p.toFile().getName().endsWith(name)).forEach(System.out::println);

        }
        in.close();
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
