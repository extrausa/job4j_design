package ru.job4j.io;
//2. Анализ доступности сервера. [#859]
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> separated = new ArrayList<>();
        List<String> queue = new LinkedList<>();

        int badRequest = 400;
        int internalServerError = 500;
        boolean point = false;
//        source = "./server.log";
//        target = "./unavailable.csv";
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                separated = Arrays.asList(line.split(" "));
                if (Integer.parseInt(separated.get(0)) == badRequest || Integer.parseInt(separated.get(0)) == internalServerError) {
                    queue.add(separated.get(1));
                }else {
                    continue;
                }
            }
            if (queue.size() != 0) {
                try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {

                    out.println(queue.get(0));
                    out.println(queue.get(queue.size() - 1));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
//        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
//            out.println("15:01:30;15:02:32");
//            out.println("15:10:30;23:12:32");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        String source = "./server.log";
        String target = "./unavailable.csv";
        Analizy first = new Analizy();
        first.unavailable(source, target);
    }
}
