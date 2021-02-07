package main.java.java8.Lambdas.electricityConsumer;

public class Lamp implements ElectricityConsumer {

    public void lightOn() {
        System.out.println("Lamp is on");
    }

    @Override
    public void electricityOn() {
        this.lightOn();
    }
}
