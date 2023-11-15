package christmas.view.display;

public abstract class ResultView {
    public void proceed() {
        printTitle();
        printResult();
        System.out.println();
    }

    abstract void printTitle();

    abstract void printResult();
}
