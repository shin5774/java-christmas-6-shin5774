package christmas.controller.display;

import christmas.GiveawayEvent;
import christmas.Orders;
import christmas.view.output.GiveawayMenuView;

public class DisplayGiveawayMenuController implements DisplayController {
    private final Orders orders;

    public DisplayGiveawayMenuController(Orders orders) {
        this.orders = orders;
    }

    @Override
    public void process() {
        int beforeOrderPrice = orders.getTotalOrderAmount();
        new GiveawayMenuView(GiveawayEvent.getGiveawayEventItems(beforeOrderPrice)).process();
    }
}
