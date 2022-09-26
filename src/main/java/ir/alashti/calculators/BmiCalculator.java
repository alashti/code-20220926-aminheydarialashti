package ir.alashti.calculators;

public class BmiCalculator {

    @Deprecated
    public static float calculateLegacy(int height, int weight) {
        String format = String.format("%.1f", (float) (weight / Math.pow(height * 0.01, 2)));
        return Float.valueOf(format);
    }

    public static float calculate(int height, int weight) {
        int bmi = (int) (((float) weight / Math.pow(height * 0.01, 2)) * 10);
        return (float) bmi / 10;
    }
}
