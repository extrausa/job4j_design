package ru.job4j.io;
//6. Кодировка. [#862]
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private List<String> dataTemp = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public String run(String word) {
        String answer = word;

        if (answer.equals(OUT)) {
            dataTemp.add(OUT);
            writeDataInFile(botAnswers, dataTemp);
        } else if (answer.equals(STOP)) {
            dataTemp.add(STOP);
        } else {
            dataTemp.add(word);
            String answerWord = readFile(path);
            dataTemp.add(answerWord);
            return answerWord;
        }
        return null;
    }

    public String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
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
        String path = "/home/extrausa/IdeaProjects/job4j_design/test/textWord.txt";
        String botAnswers = "/home/extrausa/IdeaProjects/job4j_design/test/textAswer.txt";
        ConsoleChat cc = new ConsoleChat(path, botAnswers);
        Scanner in;
        String fileinput = null;
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите слово");
            in = new Scanner(System.in);
            cc.run(in.next());
        }
    }
}


