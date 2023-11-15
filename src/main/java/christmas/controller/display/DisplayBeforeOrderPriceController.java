package christmas.controller.display;

import christmas.TotalOrderAmount;
import christmas.view.output.BeforeOrderPriceView;

public class DisplayBeforeOrderPriceController implements DisplayController {
    private final TotalOrderAmount totalOrderAmount;

    public DisplayBeforeOrderPriceController(TotalOrderAmount totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    @Override
    public void process() {
        new BeforeOrderPriceView(totalOrderAmount.getAmount()).process();
    }

}
