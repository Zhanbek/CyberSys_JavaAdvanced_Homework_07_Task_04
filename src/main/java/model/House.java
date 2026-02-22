package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class House {

    private int number;

    private int floors;

    public House() {}

    public House(int number, int floors) {
        this.number = number;
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "House{" +
                "floors=" + floors +
                ", number=" + number +
                '}';
    }
}