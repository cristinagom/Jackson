import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.Car;
import model.Character;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeCar() {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("red", "renault");
        File f = new File("src/main/resources/car.json");

        try {
            objectMapper.writeValue(f, car);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readCar() {
        ObjectMapper objectMapper = new ObjectMapper();
        File f = new File("src/main/resources/car.json");

        try {
            Car car2 = objectMapper.readValue(f, Car.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeCars() {
        ObjectMapper mapper = new ObjectMapper();

        Car car1 = new Car("red", "renault");
        Car car2 = new Car("blue", "renault");
        List<Car> list1 = new ArrayList<>();
        list1.add(car1);
        list1.add(car2);

        List<Car> list2 = new ArrayList(List.of(new Car("red", "renault"), new Car("blue", "renault")));

        File f = new File("src/main/resources/cars.json");

        try {
            String jsonArray1 = mapper.writeValueAsString(list1);
            System.out.println(jsonArray1);
            mapper.writeValue(f, list2);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readCars() {
        ObjectMapper mapper = new ObjectMapper();
        File f = new File("src/main/resources/cars.json");
        try {
            List<Car> asList = mapper.readValue(f, new TypeReference<List<Car>>() { });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readColorCars() {
        ObjectMapper mapper = new ObjectMapper();
        File f = new File("src/main/resources/cars.json");

        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(f);
            List<JsonNode> colors = jsonNode.findValues("color");
            for(JsonNode color: colors) {
                System.out.println(color.asText());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readColorCar() {
        ObjectMapper mapper = new ObjectMapper();
        File f = new File("src/main/resources/car.json");

        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(f);
            String color = jsonNode.get("color").asText();
            System.out.println(color);
            /*
            Long population = jsonNode.get("population").asLong();
            Integer provinces = jsonNode.get("numberOfProvinces").asInt();
            boolean isDeveloped = jsonNode.get("developed").asBoolean();
            */

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeColorCar() {
        ObjectMapper mapper = new ObjectMapper();
        File f = new File("src/main/resources/car.json");

        JsonNode jsonNode = null;
        try  {
            jsonNode = mapper.readTree(f);
            ((ObjectNode)jsonNode).put("color","grey");
            mapper.writeValue(f,jsonNode);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeCarXML() {
        XmlMapper xmlMapper = new XmlMapper();
        Car car1 = new Car("red", "renault");
        String xmlString = null;
        try {
            xmlString = xmlMapper.writeValueAsString(car1);
            System.out.println(xmlString);
            File xmlOutput = new File("res/car.xml");
            FileWriter fileWriter = new FileWriter(xmlOutput);
            fileWriter.write(xmlString);
            fileWriter.close();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeCarsXML() {
        XmlMapper xmlMapper = new XmlMapper();
        List<Car> list = new ArrayList(List.of(new Car("red", "renault"), new Car("blue", "renault")));
        String xmlString = null;
        try {
            xmlString = xmlMapper.writeValueAsString(list);
            System.out.println(xmlString);
            File xmlOutput = new File("res/cars.xml");
            FileWriter fileWriter = new FileWriter(xmlOutput);
            fileWriter.write(xmlString);
            fileWriter.close();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readURL() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Character rick = mapper.readValue(new URL("https://rickandmortyapi.com/api/character/1"), Character.class);
            System.out.println(rick.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        readURL();

    }

}
