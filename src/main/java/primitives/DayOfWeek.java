package main.java.primitives;
//You can't inherit from enum
//It's constructor is private by default
public enum DayOfWeek {
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday");

    private String title;

    DayOfWeek(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
