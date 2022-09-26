package ir.alashti.datastructure;

import java.util.List;

public class Report {
    long overWeightPeople;
    List<Person> bmiData;

    public Report(List<Person> people, long overWeights) {
        this.bmiData = people;
        this.overWeightPeople = overWeights;
    }

    public List<Person> getBmiData() {
        return bmiData;
    }

    public Report setBmiData(List<Person> bmiData) {
        this.bmiData = bmiData;
        return this;
    }

    public long getOverWeightPeople() {
        return overWeightPeople;
    }

    public Report setOverWeightPeople(long overWeightPeople) {
        this.overWeightPeople = overWeightPeople;
        return this;
    }
}
