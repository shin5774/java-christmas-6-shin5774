package christmas.controller.display;

import christmas.domain.Orders;
import christmas.view.display.BeforeOrderPriceView;

public class DisplayBeforeOrderPriceController implements DisplayController {
    private final Orders orders;

    public DisplayBeforeOrderPriceController(Orders orders) {
        this.orders = orders;
    }

    @Override
    public void proceed() {
        new BeforeOrderPriceView(orders.getTotalOrderAmount()).proceed();
    }

}
