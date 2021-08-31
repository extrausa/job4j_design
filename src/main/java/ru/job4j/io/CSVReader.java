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
    public List<String> modificator = new ArrayList<>();
    public List<Integer> dataIndex = new ArrayList<>();
    int count = 0;

    public List<String> reader(Path path, Charset cs, String[] filter, String delimetr) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile()), cs))) {
            try (var scanner = new Scanner(br).useDelimiter(delimetr + System.lineSeparator())) {
                while (scanner.hasNext()) {
                    if (count == 0) {
                        String name2 = scanner.nextLine();
                        parsIndex(name2, delimetr, filter);
                    }

                    String name = scanner.next();
                    count++;
                    return filter(name, dataIndex, delimetr);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Integer> parsIndex(String nameLine, String delimetr, String[] filter) {
        int countIndex = 0;
        Scanner newWord = new Scanner(nameLine).useDelimiter(delimetr);
        while (newWord.hasNext()) {
            String nameTitle = newWord.next();
            modificator.add(nameTitle.trim());
        }
        for (int i = 0; i < filter.length; i++) {
            for (int j = 0; j < modificator.size(); j++) {

                if (filter[i].equals(modificator.get(j))) {
                    dataIndex.add(countIndex);
                    //countIndex++;
                    break;
                }
                countIndex++;
            }
        }
        return dataIndex;
    }

    private List<String> filter(String line, List<Integer> mod, String delimetr) {
        int counting = 0;
        Scanner newWord = new Scanner(line).useDelimiter(delimetr);
        while (newWord.hasNext()) {
            String nameTitle = newWord.next();

            if (mod.size() > counting) {
                if (counting == mod.get(counting)) {
                    counting++;
                    list.add(nameTitle);
                    continue;
                }
            }
            if (counting >= modificator.size() - 1) {
                counting = 0;
                continue;
            }
            counting++;
        }
        return list;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Path start = Paths.get("/home/extrausa/IdeaProjects/job4j_design/test/table.csv");
        //Path start = Paths.get("/home/denis/IdeaProjects/job4j_design/test/table.csv");
        CSVReader reader = new CSVReader();
//        if (args.length != 2) {
//            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
//        }
        //ArgsName argsName = ArgsName.of(args);
        //Path start = Paths.get(argsName.get("path"));
        String output = ", "; //argsName.get("out");
        String[] name = new String[]{"name", "age"}; //argsName.get("filter").split(",");
        for (String s : reader.reader(start, StandardCharsets.UTF_8, name, output)) {
            System.out.println(s);
        }
    }
}
