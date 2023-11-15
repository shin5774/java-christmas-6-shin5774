package christmas.controller;

import christmas.Benefits;
import christmas.Orders;
import christmas.TotalOrderAmount;
import christmas.VisitedDate;
import christmas.controller.display.DisplayAfterOrderPriceController;
import christmas.controller.display.DisplayBadgeController;
import christmas.controller.display.DisplayBeforeOrderPriceController;
import christmas.controller.display.DisplayBenefitDetailsController;
import christmas.controller.display.DisplayGiveawayMenuController;
import christmas.controller.display.DisplayTotalBenefitPriceController;
import christmas.view.output.OrderDetailView;
import christmas.view.output.OutputView;

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

        printResult(totalOrderAmount, benefits, orders);
    }

    private void printResult(TotalOrderAmount totalOrderAmount, Benefits benefits, Orders orders) {
        displayBeforeOrderPrice(totalOrderAmount);
        displayGiveawayMenu(totalOrderAmount);
        displayBenefitDetails(benefits);
        displayTotalBenefitPrice(benefits);
        displayAfterOrderPrice(orders, benefits);
        displayBadge(benefits);
    }

    private void displayBeforeOrderPrice(TotalOrderAmount totalOrderAmount) {
        new DisplayBeforeOrderPriceController(totalOrderAmount).process();
    }

    private void displayGiveawayMenu(TotalOrderAmount totalOrderAmount) {
        new DisplayGiveawayMenuController(totalOrderAmount).process();
    }

    private void displayBenefitDetails(Benefits benefits) {
        new DisplayBenefitDetailsController(benefits).process();
    }

    private void displayTotalBenefitPrice(Benefits benefits) {
        new DisplayTotalBenefitPriceController(benefits).process();
    }

    private void displayAfterOrderPrice(Orders orders, Benefits benefits) {
        new DisplayAfterOrderPriceController(orders, benefits).process();
    }

    private void displayBadge(Benefits benefits) {
        new DisplayBadgeController(benefits).process();
    }
}
