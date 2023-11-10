package christmas.exception;

public class MenuException extends IllegalArgumentException {
    private MenuException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public static MenuException from(String exceptionMessage) {
        return new MenuException(exceptionMessage);
    }
}
