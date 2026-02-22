package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    private String name;

    private String size;

    @XmlElement(name = "street")
    private List<Street> streets = new ArrayList<>();

    public City() {}

    public City(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public void addStreet(Street street) {
        streets.add(street);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", streets=" + Arrays.deepToString(streets.toArray()) +
                '}';
    }
}