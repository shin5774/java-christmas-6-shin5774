package christmas.controller.display;

import christmas.domain.Orders;
import christmas.view.output.BeforeOrderPriceView;

public class DisplayBeforeOrderPriceController implements DisplayController {
    private final Orders orders;

    public DisplayBeforeOrderPriceController(Orders orders) {
        this.orders = orders;
    }

    @Override
    public void process() {
        new BeforeOrderPriceView(orders.getTotalOrderAmount()).process();
    }

}
