package christmas.controller;

import christmas.Benefits;
import christmas.Orders;
import christmas.UserInformation;
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
        UserInformation userInformation = new UserInformation(visitedDate, orders);

        outputView.printResultStartMessage();
        new OrderDetailView(userInformation.getOrderDetails()).process();

        Benefits benefits = new CalculateBenefitsController(userInformation).proceed();

        printResult(benefits, orders);
    }

    private void printResult(Benefits benefits, Orders orders) {
        displayBeforeOrderPrice(orders);
        displayGiveawayMenu(orders);
        displayBenefitDetails(benefits);
        displayTotalBenefitPrice(benefits);
        displayAfterOrderPrice(orders, benefits);
        displayBadge(benefits);
    }

    private void displayBeforeOrderPrice(Orders orders) {
        new DisplayBeforeOrderPriceController(orders).process();
    }

    private void displayGiveawayMenu(Orders orders) {
        new DisplayGiveawayMenuController(orders).process();
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
