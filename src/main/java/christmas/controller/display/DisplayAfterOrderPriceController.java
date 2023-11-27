package christmas.controller.display;

import christmas.domain.Benefits;
import christmas.domain.Orders;
import christmas.view.display.AfterOrderPriceView;

public class DisplayAfterOrderPriceController implements DisplayController {
    private final Orders orders;
    private final Benefits benefits;
    private static final int MINIMUM_AFTER_ORDER_PRICE = 0;

    public DisplayAfterOrderPriceController(Orders orders, Benefits benefits) {
        this.orders = orders;
        this.benefits = benefits;
    }

    @Override
    public void proceed() {
        new AfterOrderPriceView(getAfterOrderPrice()).proceed();
    }

    private int getAfterOrderPrice() {
        int totalBenefitPrice = benefits.getTotalBenefitAmount();

        if (benefits.hasGiveawayEvent()) {
            totalBenefitPrice += getExceptBenefitPrice();
        }

        return Math.max(orders.getTotalOrderPrice() + totalBenefitPrice, MINIMUM_AFTER_ORDER_PRICE);
    }

    private int getExceptBenefitPrice() {
        return orders.getSomeContainMenusPrice() + orders.getNotContainMenusPrice();
    }
}
