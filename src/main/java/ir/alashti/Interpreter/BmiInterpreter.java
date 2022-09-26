package ir.alashti.Interpreter;

public enum BmiInterpreter {
    UNDER_WEIGHT(Float.MIN_VALUE, 18.4f,"Malnutrition risk"),
    NORMAL_WEIGHT(15.8f, 24.9f,"Low risk"),
    OVER_WEIGHT(25f, 29.9f,"Enhanced risk"),
    MODERATELY_OBESE(30f, 34.9f,"Medium risk"),
    SEVERELY_OBESE(35f, 39.9f,"High risk"),
    VERY_SEVERELY_OBESE(40f, Float.MAX_VALUE,"Very high risk"),
    UNKNOWN(0f, 0f,"UNKNOWN");

    float lowerBound, upperBound;

    String healthRisk;

    BmiInterpreter(float lowerBound, float upperBound, String healthRisk) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.healthRisk = healthRisk;
    }

    public static BmiInterpreter interpret(float bmi) {
        BmiInterpreter[] values = BmiInterpreter.values();
        for (BmiInterpreter mtdata : values) {
            if(Float.compare(mtdata.upperBound, bmi) > 0)
                return mtdata;
        }
        return UNKNOWN;
    }

    public String getHealthRisk() {
        return healthRisk;
    }
}
