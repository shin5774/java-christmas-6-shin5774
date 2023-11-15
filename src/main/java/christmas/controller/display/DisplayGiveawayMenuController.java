package christmas.controller.display;

import christmas.domain.GiveawayEvent;
import christmas.domain.Orders;
import christmas.view.display.GiveawayMenuView;

public class DisplayGiveawayMenuController implements DisplayController {
    private final Orders orders;

    public DisplayGiveawayMenuController(Orders orders) {
        this.orders = orders;
    }

    @Override
    public void proceed() {
        int beforeOrderPrice = orders.getTotalOrderPrice();
        new GiveawayMenuView(GiveawayEvent.getGiveawayEventMenuResult(beforeOrderPrice)).proceed();
    }
}
