package ru.job4j.io.json.Pet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;

public class InOutXML {
    public static void main(String[] args) throws JAXBException {

        final Pet pet = new Pet(true, 5, "Patrick",
                new OwnerCard("Jack", "123-123"),
                "Rick", "Mortilda");
        /**Получаем контекст для доступа к АПИ*/
        JAXBContext context = JAXBContext.newInstance(Pet.class);
        /**Создаем сериализатор*/
        Marshaller marshaller = context.createMarshaller();
        /**Указываем, что нам нужно форматирование*/
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (
                StringWriter writer = new StringWriter()) {
            /** Сериализуем*/
            marshaller.marshal(pet, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
