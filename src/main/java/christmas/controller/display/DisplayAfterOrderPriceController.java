package christmas.controller.display;

import christmas.domain.Benefits;
import christmas.domain.Orders;
import christmas.view.output.AfterOrderPriceView;

public class DisplayAfterOrderPriceController implements DisplayController {
    private final Orders orders;
    private final Benefits benefits;

    public DisplayAfterOrderPriceController(Orders orders, Benefits benefits) {
        this.orders = orders;
        this.benefits = benefits;
    }

    @Override
    public void process() {
        new AfterOrderPriceView(orders.getAfterOrderPrice(benefits)).process();
    }
}
