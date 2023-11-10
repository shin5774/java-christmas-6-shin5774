package christmas;

import java.util.List;

public class Promotion {

    public boolean isChristMasDiscount(int day) {
        return day <= 25;
    }

    public boolean isWeekDayDiscount(int day) {
        return !(day % 7 == 1 || day % 7 == 2);
    }

    public boolean isSpecialDiscount(int day) {
        return List.of(3, 10, 17, 24, 25, 31).contains(day);
    }
}
