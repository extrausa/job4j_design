package ru.job4j.io;
//5.1. Именованные аргументы [#295518]
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-Xmx")) {
                int a = args[i].length();
                if (args[i].length() <= 5) {
                    throw new IllegalArgumentException();
                }
                String line = args[i];
                int iend = line.indexOf("=");
                values.put(line.substring(1, iend), line.substring(++iend, line.length()));
                break;
            } else {
                continue;
            }
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
