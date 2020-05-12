package main.java.primitives;

public class DayOfWeek_A {
    private String title;

    public DayOfWeek_A(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public static void main(String[] args) {
        DayOfWeek_A day = new DayOfWeek_A("sunday");
        System.out.println(day);
    }
}
