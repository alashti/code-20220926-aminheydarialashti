package ir.alashti.datastructure;

import com.google.gson.annotations.SerializedName;

public class Person {
    @SerializedName("Gender")
    String gender;
    @SerializedName("HeightCm")
    int height;
    @SerializedName("WeightKg")
    int weight;
    float bmi;
    String bmiCategory;
    String healthRisk;

    public int getHeight() {
        return height;
    }

    public Person setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public Person setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Person setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public float getBmi() {
        return bmi;
    }

    public Person setBmi(float bmi) {
        this.bmi = bmi;
        return this;
    }

    public String getBmiCategory() {
        return bmiCategory;
    }

    public Person setBmiCategory(String bmiCategory) {
        this.bmiCategory = bmiCategory;
        return this;
    }

    public String getHealthRisk() {
        return healthRisk;
    }

    public Person setHealthRisk(String healthRisk) {
        this.healthRisk = healthRisk;
        return this;
    }
}
