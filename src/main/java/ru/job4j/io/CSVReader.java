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
    public Map<String, Integer> map = new HashMap<>();

    public List<String> reader(Path path, Charset cs, String[] filter) throws FileNotFoundException {
        String nameUser = "name";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile()), cs))) {
            br.lines().forEach(s -> list.add(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            if (count == 0) {
                Scanner words = new Scanner(new ByteArrayInputStream(list.get(i).getBytes(StandardCharsets.UTF_8))).useDelimiter(", ");
                for (Scanner it = words; it.hasNext();) {
                    String a = it.next();
                    map.put(a, count++);
                }
                count = 0;
            }
        }
        List<String> templist = new ArrayList<>();
        int countWhile = 0;
        while (filter.length < countWhile) {
            for (int i = 0; i < map.size(); i++) {
                String namePoint = filter[countWhile];
                int keyTemp = map.get(namePoint).intValue();
                if (map.containsValue(keyTemp)) {

                    templist.add(map.get(namePoint).toString());
                }
            }
            countWhile++;
        }
        return list;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Path start = Paths.get("/home/extrausa/IdeaProjects/job4j_design/test/table.csv");
        //Path start = Paths.get("/home/denis/IdeaProjects/job4j_design/test/table.csv");
        CSVReader reader = new CSVReader();
        String[] name = new String[]{"name", "age"};
        for (String s : reader.reader(start, StandardCharsets.UTF_8, name)) {
            System.out.println(s);
        }
    }
}
