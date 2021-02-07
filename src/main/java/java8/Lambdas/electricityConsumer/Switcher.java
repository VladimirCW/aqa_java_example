package main.java.java8.Lambdas.electricityConsumer;

import java.util.ArrayList;
import java.util.List;

public class Switcher {

    private List<ElectricityConsumer> consumers = new ArrayList<>();

    public void add(ElectricityConsumer consumer) {
        this.consumers.add(consumer);
    }

    public void remove(ElectricityConsumer consumer) {
        this.consumers.remove(consumer);
    }

    public void switchOn() {
        System.out.println("Switcher is on");
        for (ElectricityConsumer consumer: this.consumers) {
            consumer.electricityOn();
        }
    }
}
