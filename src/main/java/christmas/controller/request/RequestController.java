package christmas.controller.request;

import christmas.view.display.ErrorView;

public abstract class RequestController<E> {
    private final ErrorView errorView = new ErrorView();

    public E process() {
        try {
            return active();
        } catch (IllegalArgumentException exception) {
            errorView.printExceptionMessage(exception.getMessage());
            return process();
        }
    }

    abstract E active();
}
