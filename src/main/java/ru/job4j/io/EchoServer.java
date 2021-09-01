package ru.job4j.io;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
//0. Что такое Socket? [#4850]00
public class EchoServer {
    public static void main(String[] args) throws IOException {
        //Сначала нам нужно создать сервер.
        //ServerSocket создает сервер. Чтобы клиент мог узнать, где находится сервер ему нужен адрес и порт.
        // По аналогии с людьми мы обращаемся по имени, чтобы начать разговор.
        //9000 - это порт. По умолчанию адрес будет localhost.
        try (ServerSocket server = new ServerSocket(9000)) {
            //Следующее условие говорит о том, что сервер работает, пока его принудительно не закроют
            //метод ассеpt принимает один запрос от клиента, чтобы отправить второй, программа должна снова получить объект socket.
            while (!server.isClosed()) {
                //server.acсept - ожидает, когда к нему обратиться клиент. Программа переходит в режим ожидания.
                Socket socket = server.accept();
                // Когда клиент обратился к серверу программа получает входной поток и может отправить данные в выходной поток.
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String word = in.readLine();
                    String[] wordArray = word.split(" ");
                    for (int i = 0; i < wordArray.length; i++) {
                        if (wordArray[i].endsWith("Bye")) {
                            server.close();
                        }
                    }
                    //В ответ мы записываем строчку.
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    //В программе читается весь входной поток.
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                    }
                    //После чтения отправляем ответ окончательно.
                    out.flush();
                }
            }
        }
    }
}



