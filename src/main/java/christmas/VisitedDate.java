package christmas;

public class VisitedDate {
    private static final int START_DATE = 1;
    private static final int END_DATE = 31;
    private final int date;

    private VisitedDate(int date) {
        validate(date);
        this.date = date;
    }

    public static VisitedDate of(int date) {
        return new VisitedDate(date);
    }

    private void validate(int date) {
        if (date < START_DATE || date > END_DATE) {
            throw new IllegalArgumentException();
        }
    }
}
