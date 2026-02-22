package Homework_07_Task_04;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import model.Cities;
import model.City;
import model.House;
import model.Street;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import java.io.File;

@SpringBootApplication
public class CyberSysJavaAdvancedHomework07Task04Application {

    public static void main(String[] args) throws JAXBException {
        SpringApplication.run(CyberSysJavaAdvancedHomework07Task04Application.class, args);

        System.out.println();
        System.out.println("CyberSysJavaAdvancedHomework07Task04Application started");
        System.out.println();

        // Створюємо масив міст
        Cities cities = createCitiesAndLoadData();
        System.out.println("Cities: " + cities);

        JAXBContext context = JAXBContext.newInstance(Cities.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(cities, new File("cities.xml"));

        System.out.println("XML created successfully!");
    }

    private static Cities createCitiesAndLoadData() {
        List<City> cityArrayList = new ArrayList<>();

        // Київ
        City kyiv = new City("Київ", "великий");

        Street khreshchatyk = new Street("Хрещатик");
        khreshchatyk.addHouse(new House(1, 5));
        khreshchatyk.addHouse(new House(2, 4));

        Street andriivskyi = new Street("Андріївський узві");
        andriivskyi.addHouse(new House(10, 3));
        andriivskyi.addHouse(new House(12, 2));

        kyiv.addStreet(khreshchatyk);
        kyiv.addStreet(andriivskyi);
        cityArrayList.add(kyiv);

        //  Львів
        City lviv = new City("Львів", "середник");

        Street rynok = new Street("Площа Ринок");
        rynok.addHouse(new House(5, 4));
        rynok.addHouse(new House(6, 4));

        Street shevchenka = new Street("Проспект Шевченка");
        shevchenka.addHouse(new House(15, 6));
        shevchenka.addHouse(new House(17, 5));

        lviv.addStreet(rynok);
        lviv.addStreet(shevchenka);
        cityArrayList.add(lviv);

        return new Cities(cityArrayList);
    }

}
