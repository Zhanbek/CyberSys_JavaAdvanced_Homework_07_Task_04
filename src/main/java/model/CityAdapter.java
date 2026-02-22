package model;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.List;

public class CityAdapter extends XmlAdapter<CityAdapter.AdaptedCity, City> {

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class AdaptedCity {
        @XmlAttribute
        public String size;

        @XmlValue
        public String name;

        // БЕЗ АНОТАЦІЙ!
        public List<Street> streets;
    }

    @Override
    public AdaptedCity marshal(City city) throws Exception {
        AdaptedCity adapted = new AdaptedCity();
        adapted.size = city.getSize();
        adapted.name = city.getName();
        adapted.streets = city.getStreets();
        return adapted;
    }

    @Override
    public City unmarshal(AdaptedCity adapted) throws Exception {
        City city = new City(adapted.name, adapted.size);
        if (adapted.streets != null) {
            for (Street street : adapted.streets) {
                city.addStreet(street);
            }
        }
        return city;
    }
}