package christmas;

import christmas.controller.Controller;
import christmas.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new OutputView());
        controller.start();
    }
}
