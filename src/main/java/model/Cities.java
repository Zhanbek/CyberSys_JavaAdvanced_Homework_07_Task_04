package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "cities")
public class Cities {

    @XmlElement(name = "city")
    private List<City> cities = new ArrayList<>();

    public Cities() {}

    public Cities(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "cities=" + Arrays.deepToString(cities.toArray()) +
                '}';
    }
}