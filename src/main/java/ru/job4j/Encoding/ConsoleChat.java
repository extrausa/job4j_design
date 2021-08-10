package ru.job4j.Encoding;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> answer = List.of("привет", "пока");


        writeDataInFile(path, answer);

    }

    public String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path, Charset.forName("WINDOWS-1258")))) {
            br.lines().forEach(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    private void writeDataInFile(String path, List<String> data) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1258"), true))) {
            data.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "/home/denis/IdeaProjects/job4j_design/test/text.txt";
        ConsoleChat cc = new ConsoleChat(path, "");
        Scanner in = new Scanner(System.in);
        String h = null;
        System.out.println("Введите слово");
        while (in.hasNext()) {
            System.out.println("Введите слово");
            h = in.next();
            cc.run();
            System.out.println();
        }
        cc.run();
    }
}
