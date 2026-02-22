package model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "size")
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

    public String getName() { return name; }
    public String getSize() { return size; }
    public List<Street> getStreets() { return streets; }

    @Override
    public String toString() {
        return "City {" +
                "name =  '" + name + '\'' +
                ", size ='" + size + '\'' +
                ", streets = " + Arrays.deepToString(streets.toArray()) +
                '}';
    }
}