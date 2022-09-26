package ir.alashti.controllers;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ir.alashti.datastructure.Person;
import ir.alashti.datastructure.Report;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class BmiSplitter {

    static Gson gson = new Gson();
    private static Type inputType = new TypeToken<List<Person>>() {
    }.getType();
    static int processors = Runtime.getRuntime().availableProcessors();
    AtomicLong overWeightsCount;
    ThreadPoolExecutor threadPool;

    public BmiSplitter() {
        overWeightsCount = new AtomicLong(0);
        threadPool = new ThreadPoolExecutor(processors, processors, 10, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(processors));
        threadPool.allowCoreThreadTimeOut(true);
    }

    public String addBmiData(String json) {
        List<Person> people = gson.fromJson(json, inputType);
        List<List<Person>> partition = Lists.partition(people, (int) Math.ceil((float) people.size() / processors));
        for (List<Person> personList : partition) {
            BmiThread thread = new BmiThread(personList, overWeightsCount);
            threadPool.execute(thread);
        }
        try {
            threadPool.awaitTermination(6, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Report report = new Report(people, overWeightsCount.get());
        return gson.toJson(report);
    }

    public AtomicLong getOverWeightsCount() {
        return overWeightsCount;
    }
}
