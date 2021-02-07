package main.java.java8.Lambdas.electricityConsumer;

public class Radio implements ElectricityConsumer{

    public void playMusic() {
        System.out.println("Radio is playing");
    }

    @Override
    public void electricityOn() {
        this.playMusic();
    }
}
