package christmas.controller.display;

import christmas.TotalOrderAmount;
import christmas.view.output.GiveawayMenuView;

public class DisplayGiveawayMenuController implements DisplayController {
    private final TotalOrderAmount totalOrderAmount;

    public DisplayGiveawayMenuController(TotalOrderAmount totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    @Override
    public void process() {
        new GiveawayMenuView(totalOrderAmount.getGiveawayEventItems()).process();
    }
}
