package christmas.view.display;

import static christmas.view.display.constant.PrintFormat.ORDER_DETAILS_FORMAT;

import christmas.view.display.constant.ResultTitle;
import java.util.Map;

public class GiveawayMenuView extends ResultView {
    private static final String NONE = "없음";
    private final Map<String, Integer> eventResult;

    public GiveawayMenuView(Map<String, Integer> eventResult) {
        this.eventResult = eventResult;
    }

    @Override
    void printTitle() {
        System.out.println(ResultTitle.GIVEAWAY_MENU.getMessage());
    }

    @Override
    void printResult() {
        if (eventResult.isEmpty()) {
            System.out.println(NONE);
            return;
        }

        eventResult.forEach((key, value) -> System.out.println(String.format(ORDER_DETAILS_FORMAT, key, value)));
    }
}
