package christmas.view.output;

import christmas.view.output.constant.ResultTitle;

public class GiveawayMenuView extends ResultView {
    private final String eventResult;

    public GiveawayMenuView(String eventResult) {
        this.eventResult = eventResult;
    }

    @Override
    void printTitle() {
        System.out.println(ResultTitle.GIVEAWAY_MENU.getMessage());
    }

    @Override
    void printResult() {
        System.out.println(eventResult);
    }
}
