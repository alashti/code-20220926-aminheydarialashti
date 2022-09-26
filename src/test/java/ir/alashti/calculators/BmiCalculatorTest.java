package ir.alashti.calculators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class BmiCalculatorTest {

    @Test
    void calculate() {
        float calculate = BmiCalculator.calculate(175, 75);
        Assertions.assertEquals(24.4f, calculate);
    }

    @Test
    void calculateLoadTest() {
        int sum = 0;
        Random heightRandom = new Random(System.currentTimeMillis());
        Random weightRandom = new Random(System.currentTimeMillis()-1000);
        for (int i = 0; i < 10; i++) {
            long l = System.currentTimeMillis();
            for (int j = 0; j < 1000000; j++) {
                BmiCalculator.calculateLegacy(heightRandom.nextInt(200), weightRandom.nextInt(150));
            }
            sum += System.currentTimeMillis() - l;
        }
        System.out.println(sum / 10);
        sum = 0;
        heightRandom = new Random(System.currentTimeMillis());
        weightRandom = new Random(System.currentTimeMillis()-1000);
        for (int i = 0; i < 10; i++) {
            long l = System.currentTimeMillis();
            for (int j = 0; j < 1000000; j++) {
                BmiCalculator.calculate(heightRandom.nextInt(200), weightRandom.nextInt(150));
            }
            sum += System.currentTimeMillis() - l;
        }
        System.out.println(sum / 10);
    }
}