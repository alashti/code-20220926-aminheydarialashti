package ir.alashti.controllers;

import ir.alashti.Interpreter.BmiInterpreter;
import ir.alashti.calculators.BmiCalculator;
import ir.alashti.controllers.BmiSplitter;
import ir.alashti.datastructure.Person;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class BmiThread implements Runnable {
    private final AtomicLong overWeightsCount;
    private final List<Person> people;

    public BmiThread(List<Person> people, AtomicLong overWeightsCount) {
        this.people = people;
        this.overWeightsCount = overWeightsCount;
    }

    @Override
    public void run() {
        for (Person inf : people) {
            float bmi = BmiCalculator.calculate(inf.getHeight(), inf.getWeight());
            BmiInterpreter interpret = BmiInterpreter.interpret(bmi);
            System.out.println(interpret);
            if (interpret == BmiInterpreter.OVER_WEIGHT) {
                overWeightsCount.addAndGet(1);
            }
            inf
                    .setBmi(bmi)
                    .setBmiCategory(interpret.name())
                    .setHealthRisk(interpret.getHealthRisk())
            ;
        }
    }
}
