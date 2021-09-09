package ru.job4j.io.json.Pet;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ownerCard")
public class OwnerCard {

    @XmlAttribute
    private  String name;

    @XmlAttribute
    private  String phone;

    public OwnerCard() {
    }

    public OwnerCard(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "OwnerCard{" +  "name='" + name + '\'' + ", phone=" + phone + '}';
    }
}
