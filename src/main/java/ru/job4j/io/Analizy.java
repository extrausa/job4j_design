package ru.job4j.io;
//2. Анализ доступности сервера. [#859]
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Analizy {
    @SuppressWarnings("checkstyle:WhitespaceAround")
    public void unavailable(String source, String target) {
        List<String> separated = new ArrayList<>();
        List<String> queue = new LinkedList<>();
        int count = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                separated = Arrays.asList(line.split(" "));
                if ((line.startsWith("400") || line.startsWith("500"))) {
                    if (count == 1) {
                        continue;
                    } else {
                        queue.add(separated.get(1));
                        count++;
                    }
                } else if (count > 0) {
                    queue.add(separated.get(1));
                    count = 0;
                } else {
                    continue;
                }
            }
            if (queue.size() != 0) {
                try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
                    for (int i = 0; i < queue.size() - 1; i++) {
                        out.println(queue.get(i) + " " + queue.get(i + 1));
                        i++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String source = "./server.log";
        String target = "./unavailable.csv";
        Analizy first = new Analizy();
        first.unavailable(source, target);
    }
}
