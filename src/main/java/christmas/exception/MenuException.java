package christmas.exception;

public class MenuException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private MenuException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public static MenuException from(String exceptionMessage) {
        return new MenuException(exceptionMessage);
    }

    public static MenuException occur() {
        return new MenuException(EXCEPTION_MESSAGE);
    }
}
