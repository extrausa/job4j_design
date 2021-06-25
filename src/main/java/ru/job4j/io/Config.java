package ru.job4j.io;
//1. Читаем файл конфигурации [#858]
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Config {

    private final String path; //"./data/pair_without_comment.properties;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        String[] substr;
        List<String> list = new ArrayList<>();
        char first;
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                list = Arrays.asList(line.split("="));
                for (int i = 0; i < list.size(); i++) {
                    if (line.trim().length() == 0) {
                        break;
                    }
                    first = list.get(0).charAt(0);
                    if (first == 35) {
                        break;
                    } else if (list.size() == 1) {
                        throw new IllegalArgumentException("No value");
                    }
                    if (list.size() == 2) {
                        values.put(list.get(0), list.get(1));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        for (String s : values.values()) {
            if (s.contains(key)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }


}
