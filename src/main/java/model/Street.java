package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Street {

    private String name;

    @XmlElement(name = "house")
    private List<House> houses = new ArrayList<>();

    public Street() {}

    public Street(String name) {
        this.name = name;
    }

    public void addHouse(House house) {
        houses.add(house);
    }

    @Override
    public String toString() {
        return "Street{" +
                "houses=" + Arrays.deepToString(houses.toArray()) +
                ", name='" + name + '\'' +
                '}';
    }
}