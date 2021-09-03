package ru.job4j.io;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
//0. Что такое Socket? [#4850]00
//1. Бот [#7921]
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String word = in.readLine();
                    String[] wordArray = word.split(" ");
                    for (String answerWord : wordArray) {
                        if (answerWord.endsWith("Hello")) {
                            out.write("Hello".getBytes());
                        } else if (answerWord.endsWith("Exit")) {
                            server.close();
                        } else if (answerWord.endsWith("Any")) {
                            out.write("What".getBytes());
                        }
                    }
                    //out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    //out.write("Hello, dear friend.".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                    }
                    out.flush();
                }
            }
        }
    }
}



