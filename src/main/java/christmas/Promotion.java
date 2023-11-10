package christmas;

public class Promotion {

    public boolean isChristMasDiscount(int day) {
        return day <= 25;
    }

    public boolean isWeekDayDiscount(int day) {
        return !(day % 7 == 1 || day % 7 == 2);
    }
}
