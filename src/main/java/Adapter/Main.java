package Adapter;

public class Main {
    public static void main(String[] args) {
        NewDateInterface dateAdapter = new CalendarToNewDateAdapter();

        dateAdapter.setDay(15);
        dateAdapter.setMonth(5);
        dateAdapter.setYear(2023);

        System.out.println("Initial Date: " + dateAdapter.getDay() + "/" + dateAdapter.getMonth() + "/" + dateAdapter.getYear());

        dateAdapter.advanceDays(10);

        System.out.println("New Date after advancing 10 days: " + dateAdapter.getDay() + "/" + dateAdapter.getMonth() + "/" + dateAdapter.getYear());

        dateAdapter.advanceDays(25);

        System.out.println("New Date after advancing 25 days: " + dateAdapter.getDay() + "/" + dateAdapter.getMonth() + "/" + dateAdapter.getYear());
    }
}

