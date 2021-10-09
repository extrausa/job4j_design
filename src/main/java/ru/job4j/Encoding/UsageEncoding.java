package ru.job4j.Encoding;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;
import java.util.SortedMap;

public class UsageEncoding {
    public String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path, Charset.forName("WINDOWS-1251")))) {
            br.lines().forEach(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void writeDataInFile(String path, List<String> data) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            data.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "/home/denis/IdeaProjects/job4j_design/test/text.txt";
        UsageEncoding usageEncoding = new UsageEncoding();
        List<String> strings = List.of(
                "Новая строка 1",
                "Новая строка 2",
                "Новая строка 3",
                "Новая строка 4",
                "Новая строка 5"
        );
        usageEncoding.writeDataInFile(path, strings);
        String s = usageEncoding.readFile(path);
        System.out.println("данные из файла: ");
        System.out.println(s);
    }
}
