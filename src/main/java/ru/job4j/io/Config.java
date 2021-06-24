package ru.job4j.io;
//1. Читаем файл конфигурации [#858]
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path; //"./data/pair_without_comment.properties;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        String[] substr;
        char first;
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                substr = line.split("=");
                for (int i = 0; i < substr.length; i++) {
                    first = substr[0].charAt(0);
                    if (first == 23) {
                        break;
                    } else if (substr.length == 1) {
                        throw new IllegalArgumentException("No value");
                    }
                    if (substr.length =) {
                        values.put(substr[0], substr[1]);
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
