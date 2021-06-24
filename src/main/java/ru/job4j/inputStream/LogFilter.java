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
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
           for (String line = in.readLine(); line != null; line = in.readLine()) {
                    substr = line.split(" ");
               for (int i = substr.length - 1; i >= substr.length - 5; i--) {
                   if (substr[i].contains("404")) {
                       temp.add(line);
                       break;
                   }
               }
           }
        } catch (Exception e) {
                e.printStackTrace();
        }
        return temp;
    }

    public static void main (String[] args) {
        List<String> log = filter("log.txt");
        log.stream().forEach(System.out::println);
    }
}

