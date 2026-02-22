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

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CyberSysJavaAdvancedHomework07Task04Application {

    private static final String FILE_PATH = "cities.xml";
    private static final String TRANSFORMED_PATH = "cities_transformed.xml";
    private static final String XSLT_PATH = "src/main/resources/transform.xsl";

    public static void main(String[] args) throws JAXBException, TransformerException {
        SpringApplication.run(CyberSysJavaAdvancedHomework07Task04Application.class, args);

        System.out.println();
        System.out.println("Запущено додаток для домашнього завдання Homework07_Task04");
        System.out.println();

        // Створюємо дані
        Cities cities = createCitiesAndLoadData();

        System.out.println("Об'єкт cities заповнений даними міст");
        System.out.println("----------------------------");
        System.out.println(cities);
        System.out.println("----------------------------");
        System.out.println();

        // Маршаллінг в XML
        JAXBContext context = JAXBContext.newInstance(Cities.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        System.out.println("Зберігаємо початковий XML в файл: " + FILE_PATH);

        // Спочатку зберігаємо в файл
        marshaller.marshal(cities, new File(FILE_PATH));

        // Трансформуємо XML в потрібний формат
        System.out.println("Трансформуємо XML в потрібний формат...");
        transformXML(FILE_PATH, TRANSFORMED_PATH, XSLT_PATH);

        // Виводимо трансформований XML на екран
        System.out.println("----------------------------");
        System.out.println("Трансформований XML:");
        printFile(TRANSFORMED_PATH);
        System.out.println("----------------------------");
        System.out.println("Трансформований XML збережено в: " + TRANSFORMED_PATH);
    }

    private static void transformXML(String inputPath, String outputPath, String xsltPath)
            throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(xsltPath));
        Transformer transformer = factory.newTransformer(xslt);

        Source xml = new StreamSource(new File(inputPath));
        Result result = new StreamResult(new File(outputPath));

        transformer.transform(xml, result);
    }

    private static void printFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Cities createCitiesAndLoadData() {
        List<City> cityArrayList = new ArrayList<>();

        // Київ
        City kyiv = new City("Київ", "великий");
        Street khreshchatyk = new Street("Хрещатик");
        khreshchatyk.addHouse(new House(1, 5));
        khreshchatyk.addHouse(new House(2, 4));
        Street andriivskyi = new Street("Андріївський узвіз");
        andriivskyi.addHouse(new House(10, 3));
        andriivskyi.addHouse(new House(12, 2));
        kyiv.addStreet(khreshchatyk);
        kyiv.addStreet(andriivskyi);
        cityArrayList.add(kyiv);

        // Львів
        City lviv = new City("Львів", "середній");
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