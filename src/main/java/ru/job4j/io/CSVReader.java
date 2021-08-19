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
    //public List<String> list = new ArrayList<>();
    public List<String> modificator = new ArrayList<>();
    public List<String> data = new ArrayList<>();
    int count = 0;

    public List<String> reader(Path path, Charset cs, String[] filter, String delimetr) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile()), cs))) {
            try (var scanner = new Scanner(br).useDelimiter(delimetr + "|\\n")) {
                while (scanner.hasNext()) {
                    if (count == 0) {
                        String name2 = scanner.nextLine();
                        Scanner newWord = new Scanner(name2).useDelimiter(delimetr + "|\\r\\n");
                        while (newWord.hasNext()) {
                            String nameTitle = newWord.next();
                            modificator.add(nameTitle.trim());
                            }
                    }
                    String name = scanner.next();
                    data.add(name);
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        while (filter.length > step) {
//            for (int i = 0; i < modificator.size(); i++) {
//                if (modificator.get(i).equals(filter[countModificator])) {
//                    point = i;
//                    break;
//                }
//            }
//            for (int i = 0; i < data.size(); i++) {
//                if (countPoint >= modificator.size()) {
//                    countPoint = 0;
//                }
//                if (countPoint == point) {
//                   result.add(data.get(i));
//                }
//
//                countPoint++;
//            }
//            step++;
//            countModificator++;
//        }
        return filter(data, modificator, filter);
    }

    private List<String> filter(List<String> data, List<String> mod, String[] filter) {
        List<String> result = new ArrayList<>();
        int stepModificator = 0;
        int stepFilter = 0;
        int index = 0;
        int count = 0;
        for (int i = 0; i < mod.size(); i++) {
            for (int j = 0; j < filter.length; j++) {
                if (mod.get(i).equals(filter[j])) {
                    index = i;
                }
            }
            for (int j = 0; j < data.size(); j++) {

                if (stepModificator >= mod.size()) {
                    stepModificator = 0;
                }
                if (stepModificator == index) {
                    result.add(data.get(j));
                    stepModificator++;
                    continue;
                }
                stepModificator++;
            }
            stepFilter++;
            if (stepFilter >= filter.length) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //Path start = Paths.get("/home/extrausa/IdeaProjects/job4j_design/test/table.csv");
        Path start = Paths.get("/home/denis/IdeaProjects/job4j_design/test/table.csv");
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
