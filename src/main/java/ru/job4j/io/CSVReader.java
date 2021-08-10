package ru.job4j.io;
//7. Scanner [#504791]
import javax.sql.rowset.Predicate;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public List<String> list = new ArrayList<>();
    public List<String> reader(Path path, Charset cs) throws FileNotFoundException {
        String nameUser = "name";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile()), cs))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                Scanner words = new Scanner(new ByteArrayInputStream(line.getBytes(StandardCharsets.UTF_8))).useDelimiter(", ");
                for (Scanner it = words; it.hasNext(); ) {
                    String a = it.next();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Path start = Paths.get("/home/denis/IdeaProjects/job4j_design/test/table.csv");
        CSVReader reader = new CSVReader();
        for (String s : reader.reader(start, StandardCharsets.UTF_8)) {
            System.out.println(s);
        }

    }
    
}
