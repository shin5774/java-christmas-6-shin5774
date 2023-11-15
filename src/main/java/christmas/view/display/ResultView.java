package christmas.view.display;

public abstract class ResultView {
    public void process() {
        printTitle();
        printResult();
        System.out.println();
    }

    abstract void printTitle();

    abstract void printResult();
}
