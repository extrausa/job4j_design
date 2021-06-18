package ru.job4j.outPutStream;
//0.1. FileOutputStream. [#252488]
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ResultFile {
    public static void main(String[] args) throws IOException {
        FileOutputStream fo = new FileOutputStream("result.txt");
        try {

            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    fo.write(Integer.toString(i * j).getBytes(StandardCharsets.UTF_8));
                    fo.write(" * ".getBytes(StandardCharsets.UTF_8));
                }
                fo.write("\n".getBytes(StandardCharsets.UTF_8));

            }
            fo.close();
            System.out.println("Information recorded");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
