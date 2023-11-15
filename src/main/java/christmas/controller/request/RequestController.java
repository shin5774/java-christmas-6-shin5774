package christmas.controller.request;

import christmas.view.output.OutputView;

public abstract class RequestController<E> {
    private final OutputView outputView = new OutputView();

    public E process() {
        try {
            return active();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return process();
        }
    }

    abstract E active();
}
