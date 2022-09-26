package ir.alashti;

import ir.alashti.Interpreter.BmiInterpreter;
import ir.alashti.calculators.BmiCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BmiInterpreterTest {

    @Test
    void getBmiMetaData() {
        BmiInterpreter bmiInterpreter = BmiInterpreter.interpret(BmiCalculator.calculate(187, 71));
        Assertions.assertEquals(BmiInterpreter.NORMAL_WEIGHT, bmiInterpreter);
    }
}