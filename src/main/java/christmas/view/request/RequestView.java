package christmas.view.request;

public abstract class RequestView<E> {
    public E process() {
        displayInformationMessage();
        return request();
    }

    abstract void displayInformationMessage();

    abstract E request();
}
