package ru.job4j.io.json.Pet;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "pet")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pet {

    @XmlAttribute
    private  boolean puppy;

    @XmlAttribute
    private  int age;

    @XmlAttribute
    private  String nickname;
    private  OwnerCard ownerCard;

    @XmlElementWrapper(name = "parents")
    @XmlElement(name = "parent")
    private  String[] parents;

    public Pet() {
    }

    public Pet(boolean puppy, int age, String nickname, OwnerCard ownerCard, String... parents) {
        this.puppy = puppy;
        this.age = age;
        this.nickname = nickname;
        this.ownerCard = ownerCard;
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "Pet{" + "puppy=" + puppy + ", age=" + age + ", nickname='" + nickname + '\'' + ", ownerCard=" + ownerCard + ", parents=" + Arrays.toString(parents) + '}';
    }
}
