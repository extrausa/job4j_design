package ru.job4j.io;
/** Кодировка. [#862]*/
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private List<String> dataTemp = new ArrayList<>();
    boolean checkFlag = true;
    boolean fileinput = true;
    List<String> words;
    int count = 0;

    public ConsoleChat(String path, String botAnswers) throws IOException {
        this.path = path;
        this.botAnswers = botAnswers;
        words = readFile(path, StandardCharsets.UTF_8);
    }

    public String run(String word) throws IOException {
        String answer = word;
        while (fileinput) {
            if (count == words.size()) {
                count = 0;
            }
            if (word.equals(CONTINUE)) {
                checkFlag = true;
                dataTemp.add(word);
                answer = words.get(count);
                dataTemp.add(answer);
                count++;
                return answer;
            }
            if (word.equals(OUT)) {
                dataTemp.add(OUT);
                writeDataInFile(botAnswers, dataTemp);
                fileinput = false;
                return OUT;
            } else if (word.equals(STOP)) {
                checkFlag = false;
                dataTemp.add(STOP);
                return word;
            } else if (checkFlag) {
                dataTemp.add(word);
                answer = words.get(count);
                dataTemp.add(answer);
                count++;
                return answer;
            }
            dataTemp.add(word);
            return "введите слово";
        }
            return STOP;
        }

        public List<String> readFile(String path, Charset cs) throws IOException {
            TreeSet<String> uniqueSortedWords = new TreeSet<String>();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), cs))) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    String[] words = line.split(" ");
                    for (String a : words) {
                        uniqueSortedWords.add(a);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            List<String> list = new ArrayList<String>(uniqueSortedWords);
            return list;
        }

        public void writeDataInFile(String path, List<String> data) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("UTF-8"), true))) {
                data.forEach(pw::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[]args) throws IOException {
            /**String path = "/home/extrausa/IdeaProjects/job4j_design/test/textWord.txt";*/
            String path = "/home/denis/IdeaProjects/job4j_design/test/textWord.txt";
            /**String botAnswers = "/home/extrausa/IdeaProjects/job4j_design/test/textAswer.txt";*/
            String botAnswers = "/home/denis/IdeaProjects/job4j_design/test/textAswer.txt";
            ConsoleChat cc = new ConsoleChat(path, botAnswers);
            System.out.println("Введите слово");
            Scanner in = new Scanner(System.in);
            boolean flagIn = true;
            while (flagIn) {
                String words = cc.run(in.next());
                if (words.equals("закончить")) {
                    flagIn = false;
                    break;
                }
                System.out.println(words);
            }
        }
}


