package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" + "zipCode=" + zipCode + ", phone='" + phone + '\'' + '}';
    }

    public static void main(String[] args) throws IOException {
        final Contact contact = new Contact(123456, "+7 (111) 111-11-11");
        try (FileOutputStream fos = new FileOutputStream("/home/denis/IdeaProjects/job4j_design/test/contact.json");
             ObjectOutputStream oos =
                     new ObjectOutputStream(fos)) {
            oos.writeObject(contact);
        }
        try (FileInputStream fis = new FileInputStream("/home/denis/IdeaProjects/job4j_design/test/contact.json");
             ObjectInputStream ois =
                     new ObjectInputStream(fis)) {
            final Contact contactFromFile = (Contact) ois.readObject();
            System.out.println(contactFromFile);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
