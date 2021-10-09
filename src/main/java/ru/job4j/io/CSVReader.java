package ru.job4j.io;
/**7. Scanner [#504791]*/
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    private Map<String, List<String>> mapArray = new HashMap<>();
    public List<String> list = new ArrayList<>();
    public List<String> modificator = new ArrayList<>();
    public List<Integer> dataIndex = new ArrayList<>();
    int count = 0;

    public Map<String, List<String>> reader(Path path, String[] filter, String delimetr) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile()), StandardCharsets.UTF_8));
             var scanner = new Scanner(br).useDelimiter(delimetr + System.lineSeparator())) {
                while (scanner.hasNext()) {
                    if (count == 0) {
                        String name2 = scanner.nextLine();
                        parsIndex(name2, filter, delimetr);
                    }
                    String name = scanner.nextLine();
                    count++;
                    filter(name, dataIndex, delimetr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapArray;
    }

    private List<Integer> parsIndex(String nameLine,  String[] filter, String delimetr) {
        Scanner newWord = new Scanner(nameLine).useDelimiter(delimetr);
        while (newWord.hasNext()) {
            String nameTitle = newWord.next();
            modificator.add(nameTitle.trim());
        }
        for (int i = 0; i < filter.length; i++) {
            for (int j = 0; j < modificator.size(); j++) {
                if (filter[i].equals(modificator.get(j))) {
                    dataIndex.add(j);
                    break;
                }
            }
        }
        Collections.sort(dataIndex);
        return dataIndex;
    }

    private List<String> filter(String line, List<Integer> mod, String delimetr) {

        int counting = 0;
        int countingMod = 0;
        Scanner newWord = new Scanner(line).useDelimiter(delimetr);
        while (newWord.hasNext()) {
            list.clear();
            String nameTitle = newWord.next();
            for (int i = 0; i < mod.size(); i++) {
                if (counting == mod.get(i)) {
                    mapConvert(nameTitle, mod.get(i));
                }
            }
            if (counting > modificator.size() - 1) {
                counting = 0;
                continue;
            }
            counting++;
        }
        return list;
    }

    private Map<String, List<String>> mapConvert(String nameTitle, int count) {
        List<String> list = new ArrayList<>();
        list.add(nameTitle);
        if (mapArray.isEmpty()) {
            mapArray.put(modificator.get(count), list);
        } else {
            if (mapArray.containsKey(modificator.get(count))) {
                mapArray.get(modificator.get(count)).add(nameTitle);
            } else {
                mapArray.put(modificator.get(count), list);
            }
        }
        return mapArray;
    }

    public static void main(String[] args) throws FileNotFoundException {

        /** Path start = Paths.get("/home/extrausa/IdeaProjects/job4j_design/test/table.csv"); */
        /** Path start = Paths.get("/home/denis/IdeaProjects/job4j_design/test/table.csv"); */
        /** String delimiter = ";"; */
        /** String[] filter = new String[] {"name", "age", "education"}; */

        CSVReader reader = new CSVReader();
        if (args.length != 3) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        ArgsName argsName = ArgsName.of(args);
        Path start = Paths.get(argsName.get("path"));
        String output = argsName.get("out");
        String delimiter = argsName.get("delimiter");
        String[] filter = argsName.get("filter").split(",");

        for (List<String> s : reader.reader(start, filter, delimiter).values()) {
            s.forEach(System.out::println);
        }
    }
}
