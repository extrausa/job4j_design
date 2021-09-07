package ru.job4j.io;
//1. Log4j. Логирование системы. [#95335]00
//2. Simple Loggin Facade 4 Java. [#268849]
//3. Slf4j - вывод переменных. [#268852]00

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte one = 2;
        short two = 12;
        int three = 22;
        char four = 02;
        long five = 1000;
        float six = 22.1F;
        double seven = 22.1;
        boolean eight = true;
        LOG.debug("Type : {} byte, {} short, {} int, {} char, {} long, {} float, {} double , {} boolean", one, two, three, four, five, six, seven,eight);
    }
}
