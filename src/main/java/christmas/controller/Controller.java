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
        String giveawayEvent = getGiveawayResult(totalOrderAmount);

        if (totalOrderAmount.canApplyPromotion()) {
            benefits = orders.getBenefits(visitedDate, totalOrderAmount.getGiveawayEventResult());
        }

        int totalBenefitsAmount = benefits.getTotalBenefitAmount();

        outputView.printTotalOrderAmount(totalOrderAmount.getAmount());
        outputView.printGiveawayEvent(giveawayEvent);
        outputView.printBenefits(benefits.getBenefitDetails());
        outputView.printTotalBenefitsAmount(totalBenefitsAmount);
        outputView.printExpectedPayAmount(
                totalOrderAmount.getExpectedPayAmount(benefits.getActualDiscountAmount(orders)));
        outputView.printBadge(Badge.findBadge(-totalBenefitsAmount).getName());
    }

    private String getGiveawayResult(TotalOrderAmount totalOrderAmount) {
        if (totalOrderAmount.canApplyGiveawayEvent()) {
            return "샴페인 1개";
        }
        return "없음";
    }
}
