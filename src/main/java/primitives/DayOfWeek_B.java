package main.java.primitives;

public class DayOfWeek_B {
    private String title;

    private DayOfWeek_B(String title) {
        this.title = title;
    }

    public static DayOfWeek_B SUNDAY = new DayOfWeek_B("sunday");
    public static DayOfWeek_B MONDAY = new DayOfWeek_B("monday");

    public String toString() {
        return this.title;
    }

    public static void main(String[] args) {
        System.out.println(DayOfWeek_B.SUNDAY);
    }
}
