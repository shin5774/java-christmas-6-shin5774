package christmas.view.display;

import static christmas.view.InformationMessage.PLANNER_START_MESSAGE;
import static christmas.view.InformationMessage.RESULT_START_MESSAGE;

public class OutputView {
    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public void printPlannerStartMessage() {
        System.out.println(PLANNER_START_MESSAGE);
    }

    public void printResultStartMessage() {
        System.out.println(RESULT_START_MESSAGE);
        System.out.println();
    }
}
