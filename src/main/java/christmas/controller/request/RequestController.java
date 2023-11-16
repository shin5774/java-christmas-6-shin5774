package christmas.controller.request;

import christmas.view.display.ErrorView;

public abstract class RequestController<E> {
    private final ErrorView errorView = new ErrorView();

    public E proceed() {
        try {
            return request();
        } catch (IllegalArgumentException exception) {
            errorView.printExceptionMessage(exception.getMessage());
            return proceed();
        }
    }

    abstract E request();
}
