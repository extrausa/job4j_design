package ru.job4j.io;
//4.0. File [#252491]
import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("/home/extrausa/IdeaProjects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subfile : file.listFiles()) {
            //System.out.println(subfile.getAbsoluteFile());
            System.out.println("Name derictory " + subfile.getName() + " " + " Size of elements " + subfile.length() / 1024 + "Mb");
        }
    }

}
