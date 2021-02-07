package main.java.java8.Lambdas.electricityConsumer;

public class Program {
    public static void main(String[] args) {
        Switcher switcher = new Switcher();
        Lamp lamp = new Lamp();
        switcher.add(lamp);
        Radio radio = new Radio();
        switcher.add(radio);

        /*class Fire implements ElectricityConsumer {

            @Override
            public void electricityOn() {
                System.out.println("FIRE!!!!");
            }
        }
        switcher.add(new Fire());*/
        //String str = "FIRE!!!";
        final String str = "FIRE!!!";
        //str = "A";
        switcher.add(() -> System.out.println(str));
        //event subscribe
        //switcher
        switcher.switchOn();
    }
}
