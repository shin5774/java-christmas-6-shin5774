package christmas.controller;

import christmas.Badge;
import christmas.Benefits;
import christmas.Orders;
import christmas.TotalOrderAmount;
import christmas.VisitedDate;
import christmas.view.output.AfterOrderPriceView;
import christmas.view.output.BadgeView;
import christmas.view.output.BeforeOrderPriceView;
import christmas.view.output.BenefitDetailsView;
import christmas.view.output.GiveawayMenuView;
import christmas.view.output.OrderDetailView;
import christmas.view.output.OutputView;
import christmas.view.output.TotalBenefitPriceView;

public class Controller {
    private final OutputView outputView;

    public Controller(OutputView outputView) {
        this.outputView = outputView;
    }

    public void start() {
        outputView.printPlannerStartMessage();
        VisitedDate visitedDate = new RequestVisitedDateController().process();
        Orders orders = new RequestOrdersController().process();

        outputView.printResultStartMessage();
        new OrderDetailView(orders.getOrderDetails()).process();

        TotalOrderAmount totalOrderAmount = TotalOrderAmount.from(orders.getTotalOrderAmount());

        Benefits benefits = new CalculateBenefitsController(visitedDate, orders).proceed(totalOrderAmount);

        int totalBenefitsAmount = benefits.getTotalBenefitAmount();

        new BeforeOrderPriceView(totalOrderAmount.getAmount()).process();
        new GiveawayMenuView(getGiveawayResult(totalOrderAmount)).process();
        new BenefitDetailsView(benefits.getBenefitDetails()).process();
        new TotalBenefitPriceView(totalBenefitsAmount).process();
        new AfterOrderPriceView(
                totalOrderAmount.getExpectedPayAmount(benefits.getActualDiscountAmount(orders))).process();
        new BadgeView(Badge.findBadge(-totalBenefitsAmount).getName()).process();
    }

    private String getGiveawayResult(TotalOrderAmount totalOrderAmount) {
        if (totalOrderAmount.canApplyGiveawayEvent()) {
            return "샴페인 1개";
        }
        return "없음";
    }
}
