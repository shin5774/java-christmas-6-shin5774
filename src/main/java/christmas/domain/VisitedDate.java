package christmas.domain;

import christmas.exception.VisitedDateException;
import java.util.List;

public class VisitedDate {
    private static final int START_DATE = 1;
    private static final int END_DATE = 31;
    private static final int WEEK_SIZE = 7;
    private static final int CHRISTMAS_DATE = 25;
    private static final List<Integer> WEEKEND_REAMINS = List.of(1, 2);
    private static final List<Integer> SPECIAL_DATE = List.of(3, 10, 17, 24, 25, 31);
    private final int date;

    private VisitedDate(int date) {
        validate(date);
        this.date = date;
    }

    public static VisitedDate from(int date) {
        return new VisitedDate(date);
    }

    private void validate(int date) {
        if (date < START_DATE || date > END_DATE) {
            throw VisitedDateException.occur();
        }
    }

    public int getDate() {
        return date;
    }

    public boolean isWeekday() {
        return !isWeekend();
    }

    public boolean isWeekend() {
        return WEEKEND_REAMINS.contains(date % WEEK_SIZE);
    }

    public boolean isBeforeChristmas() {
        return date <= CHRISTMAS_DATE;
    }

    public boolean isSpecialDate() {
        return SPECIAL_DATE.contains(date);
    }
}
