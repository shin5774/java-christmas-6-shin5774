package christmas.controller;

import christmas.Badge;
import christmas.Benefits;
import christmas.Orders;
import christmas.OutputView;
import christmas.TotalOrderAmount;
import christmas.VisitedDate;
import java.util.HashMap;

public class Controller {
    private final OutputView outputView;

    public Controller(OutputView outputView) {
        this.outputView = outputView;
    }

    public void start() {
        VisitedDate visitedDate = new RequestVisitedDateController().process();
        Orders orders = new RequestOrdersController().process();

        outputView.printOrderDetails(orders.getOrderDetails());

        TotalOrderAmount totalOrderAmount = TotalOrderAmount.from(orders.getTotalOrderAmount());

        Benefits benefits = Benefits.from(new HashMap<>());
        boolean isGiveawayEvent = totalOrderAmount.canApplyGiveawayEvent();
        String giveawayEvent = getGiveawayResult(isGiveawayEvent);

        if (totalOrderAmount.canApplyPromotion()) {
            benefits = orders.getBenefits(visitedDate, isGiveawayEvent);
        }

        int totalBenefitsAmount = benefits.getTotalBenefitAmount();

        outputView.printTotalOrderAmount(totalOrderAmount.toString());
        outputView.printGiveawayEvent(giveawayEvent);
        outputView.printBenefits(benefits.getBenefitDetails());
        outputView.printTotalBenefitsAmount(Integer.toString(totalBenefitsAmount));
        outputView.printExpectedPayAmount(
                Integer.toString(totalOrderAmount.getExpectedPayAmount(benefits.getActualDiscountAmount(orders))));
        outputView.printBadge(Badge.findBadge(-totalBenefitsAmount).getName());
    }

    private String getGiveawayResult(boolean isGiveawayEvent) {
        if (isGiveawayEvent) {
            return "샴페인 1개";
        }
        return "없음";
    }
}
