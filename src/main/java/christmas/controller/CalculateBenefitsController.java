package christmas.controller;

import christmas.Benefits;
import christmas.Orders;
import christmas.TotalOrderAmount;
import christmas.VisitedDate;
import java.util.Map;

public class CalculateBenefitsController {
    private final VisitedDate visitedDate;
    private final Orders orders;

    public CalculateBenefitsController(VisitedDate visitedDate, Orders orders) {
        this.visitedDate = visitedDate;
        this.orders = orders;
    }

    public Benefits proceed(TotalOrderAmount totalOrderAmount) {
        Map<String, Integer> giveawayEventResult = totalOrderAmount.getGiveawayEventResult();

        if (totalOrderAmount.canApplyPromotion()) {
            return orders.getBenefits(visitedDate, giveawayEventResult);
        }

        return Benefits.from(giveawayEventResult);
    }
}
