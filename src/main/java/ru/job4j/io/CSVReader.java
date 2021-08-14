package ru.job4j.io;
//7. Scanner [#504791]
import javax.sql.rowset.Predicate;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    public List<String> list = new ArrayList<>();
    public List<Integer> modificator = new ArrayList<>();
    public List<String> data = new ArrayList<>();
    int count = 0;

    public List<String> reader(Path path, Charset cs, String[] filter) throws FileNotFoundException {
        String nameUser = "name";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile()), cs))) {
            br.lines().forEach(s -> list.add(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {

            Scanner words = new Scanner(new ByteArrayInputStream(list.get(i).getBytes(StandardCharsets.UTF_8))).useDelimiter(", ");
            for (Scanner it = words; it.hasNext();) {
                String a = it.next();
                if (count == 0) {
                    modificator.add(count);
                }
                data.add(a);
            }
            count++;
        }
        for (int i = 0; i < data.size(); i++) {
            
        }
        return list;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //Path start = Paths.get("/home/extrausa/IdeaProjects/job4j_design/test/table.csv");
        Path start = Paths.get("/home/denis/IdeaProjects/job4j_design/test/table.csv");
        CSVReader reader = new CSVReader();
        String[] name = new String[]{"name", "age"};
        for (String s : reader.reader(start, StandardCharsets.UTF_8, name)) {
            System.out.println(s);
        }
    }
}
