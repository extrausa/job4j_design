package ru.job4j.inputStream;
/**
0.3. BufferedReader. [#252489]
0.4. BufferedOutputStream [#252490]
 */
import java.io.*;
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

    public static boolean save(List<String> log, String file) throws FileNotFoundException {
        boolean point = false;
        if (log.size() > 0) {
            try (PrintWriter out = new PrintWriter(
                    /** Первая обертка - это BufferedOutputStream. Это буфер, который собираем переданные в него байты */
                    new BufferedOutputStream(
                            /**Исходный поток ввода - это файл FileOutputStream.*/
                            new FileOutputStream(file)
                    ))) {
                log.stream().forEach(s -> out.printf("%s%n", s));
                point = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else  {
            point = false;
        }
        return point;

    }

    public static void main(String[] args) throws FileNotFoundException {
        List<String> log = filter("log.txt");
        if (save(log, "404.txt")) {
            System.out.println("The data is recorded");
            log.stream().forEach(System.out::println);
        } else {
            System.out.println("Data not found");
        }

    }
}

