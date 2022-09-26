package ir.alashti.controllers;

import com.google.gson.Gson;
import ir.alashti.datastructure.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class BmiSplitterTest {

    @Test
    void addBmiData() {
        String json = "[{\"Gender\": \"Male\", \"HeightCm\": 171, \"WeightKg\": 96 },\n" +
                "{ \"Gender\": \"Male\", \"HeightCm\": 161, \"WeightKg\": 85 },\n" +
                "{ \"Gender\": \"Male\", \"HeightCm\": 180, \"WeightKg\": 77 },\n" +
                "{ \"Gender\": \"Female\", \"HeightCm\": 166, \"WeightKg\": 62},\n" +
                "{\"Gender\": \"Female\", \"HeightCm\": 150, \"WeightKg\": 70},\n" +
                "{\"Gender\": \"Female\", \"HeightCm\": 167, \"WeightKg\": 82}]";
        BmiSplitter bmiSplitter = new BmiSplitter();
        String s = bmiSplitter.addBmiData(json);
        String expected = "{\"overWeightPeople\":1,\"bmiData\":[{\"Gender\":\"Male\",\"HeightCm\":171,\"WeightKg\":96,\"bmi\":32.8,\"bmiCategory\":\"MODERATELY_OBESE\",\"healthRisk\":\"Medium risk\"},{\"Gender\":\"Male\",\"HeightCm\":161,\"WeightKg\":85,\"bmi\":32.7,\"bmiCategory\":\"MODERATELY_OBESE\",\"healthRisk\":\"Medium risk\"},{\"Gender\":\"Male\",\"HeightCm\":180,\"WeightKg\":77,\"bmi\":23.7,\"bmiCategory\":\"NORMAL_WEIGHT\",\"healthRisk\":\"Low risk\"},{\"Gender\":\"Female\",\"HeightCm\":166,\"WeightKg\":62,\"bmi\":22.4,\"bmiCategory\":\"NORMAL_WEIGHT\",\"healthRisk\":\"Low risk\"},{\"Gender\":\"Female\",\"HeightCm\":150,\"WeightKg\":70,\"bmi\":31.1,\"bmiCategory\":\"MODERATELY_OBESE\",\"healthRisk\":\"Medium risk\"},{\"Gender\":\"Female\",\"HeightCm\":167,\"WeightKg\":82,\"bmi\":29.4,\"bmiCategory\":\"OVER_WEIGHT\",\"healthRisk\":\"Enhanced risk\"}]}";
        Assertions.assertEquals(expected, s);
        Assertions.assertEquals(1, bmiSplitter.getOverWeightsCount().get());
    }

    @Test
    void loadTest() {
        String json = peopleGenerator();
        long l = System.currentTimeMillis();
        BmiSplitter bmiSplitter = new BmiSplitter();
        bmiSplitter.addBmiData(json);
        System.out.println(System.currentTimeMillis() - l);
    }

    private String peopleGenerator() {
        Gson gson = new Gson();
        List<Person> people = new ArrayList<>(1000000);
        Random heightRandom = new Random(System.currentTimeMillis());
        Random weightRandom = new Random(System.currentTimeMillis()-1000);
        for (int i = 0; i < 1000000; i++) {
            Person person = new Person();
            person.setGender("Female").setHeight(heightRandom.nextInt(200)).setWeight(weightRandom.nextInt(150));
            people.add(person);
        }
        return gson.toJson(people);
    }
}