package christmas.exception;

public class VisitedDateException extends IllegalArgumentException {

    private VisitedDateException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public static VisitedDateException from(String exceptionMessage) {
        return new VisitedDateException(exceptionMessage);
    }
}
