package christmas.controller.display;

import christmas.domain.Benefits;
import christmas.domain.Orders;
import christmas.view.display.AfterOrderPriceView;

public class DisplayAfterOrderPriceController implements DisplayController {
    private final Orders orders;
    private final Benefits benefits;

    public DisplayAfterOrderPriceController(Orders orders, Benefits benefits) {
        this.orders = orders;
        this.benefits = benefits;
    }

    @Override
    public void proceed() {
        new AfterOrderPriceView(orders.getAfterOrderPrice(benefits)).proceed();
    }
}
