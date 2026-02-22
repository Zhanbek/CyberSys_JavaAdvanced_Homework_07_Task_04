package model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Street {

    @XmlElement(name = "name")
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

    public String getName() { return name; }
    public List<House> getHouses() { return houses; }

    @Override
    public String toString() {
        return "Street {" +
                "name='" + name + '\'' +
                ", houses=" + Arrays.deepToString(houses.toArray()) +

                '}';
    }
}