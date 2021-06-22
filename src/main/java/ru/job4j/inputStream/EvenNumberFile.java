package ru.job4j.inputStream;
//0.2. FileInputStream [#4898]
import java.io.FileInputStream;
//0.2. FileInputStream [#4898]
public class EvenNumberFile {
    public static void main(String[] args) {
        int[] numb = null;
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            boolean flag = false;
            while ((read = in.read()) != -1) {
                 text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                int check;
                check = Integer.parseInt(line);
                if (check % 2 == 0) {
                    System.out.println("Good");
                } else {
                    System.out.println("No");
                }
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
