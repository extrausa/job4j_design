package ru.job4j.io;
/**4.1. Сканирование файловой системы. [#106929]*/
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFiles extends SimpleFileVisitor<Path> {
    List<Path> line = new ArrayList<>();
    Predicate<Path> pred;

    public SearchFiles(Predicate<Path> condition) {
        this.pred = condition;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        if (pred.test(path)) {
            line.add(path.toAbsolutePath());
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getPaths() {
        return line;
    }
}
