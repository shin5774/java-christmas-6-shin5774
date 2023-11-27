package christmas.exception;

public class VisitedDateException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    private VisitedDateException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public static VisitedDateException from(String exceptionMessage) {
        return new VisitedDateException(exceptionMessage);
    }

    public static VisitedDateException occur() {
        return new VisitedDateException(EXCEPTION_MESSAGE);
    }
}
