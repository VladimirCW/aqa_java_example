package main.java.primitives;

public class U_Enums {
    public static void main(String[] args) {
        goToWork(DayOfWeek.MONDAY);
        goToWork(DayOfWeek.SUNDAY);
        System.out.println(DayOfWeek.MONDAY);
        //DayOfWeek dayOfWeek = new DayOfWeek("addasd");
        for (DayOfWeek el: DayOfWeek.values()) {
            System.out.println(el);
        }
    }

    public static void goToWork(DayOfWeek day) {
        switch (day) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("Go to work");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Take a rest");
                break;
        }
    }
}
