package ru.job4j.inputStream;
//0.3. BufferedReader. [#252489]
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> temp = new ArrayList<>();
        String[] substr;
        substr = file.split(" ");
        for (int i = substr.length - 1; i >= substr.length - 5; i--) {
            if (substr[i].contains("404")) {
                temp.add(file);
                return temp;
            }
        }
        return temp;
    }

    public static void main (String[] args) {
        List<String> log = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
                //in.lines().forEach(s -> filter(s));
           for (String line = in.readLine(); line != null; line = in.readLine()) {
                    if (filter(line).size() > 0) {
                        log.add(line);
                    }
                }
           log.stream().forEach(System.out::println);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //System.out.println(log);
        }
}

