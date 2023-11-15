package christmas;

import christmas.controller.display.DisplayAfterOrderPriceController;
import christmas.controller.display.DisplayBadgeController;
import christmas.controller.display.DisplayBeforeOrderPriceController;
import christmas.controller.display.DisplayBenefitDetailsController;
import christmas.controller.display.DisplayGiveawayMenuController;
import christmas.controller.display.DisplayTotalBenefitPriceController;
import christmas.controller.process.CalculateBenefitsController;
import christmas.controller.process.CreateUserInformationController;
import christmas.controller.request.RequestOrdersController;
import christmas.controller.request.RequestVisitedDateController;
import christmas.domain.Benefits;
import christmas.domain.Orders;
import christmas.domain.UserInformation;
import christmas.domain.VisitedDate;
import christmas.view.display.OrderDetailView;
import christmas.view.display.OutputView;

public class ChristmasPromotionApplication {
    private final OutputView outputView;

    public ChristmasPromotionApplication(OutputView outputView) {
        this.outputView = outputView;
    }

    public void start() {
        outputView.printPlannerStartMessage();
        VisitedDate visitedDate = requestVisitedDate();
        Orders orders = requestOrders();
        UserInformation userInformation = createUserInformation(visitedDate, orders);

        outputView.printResultStartMessage();
        displayOrderDetails(userInformation);
        Benefits benefits = calculateBenefits(userInformation);
        printResult(benefits, orders);
    }

    private VisitedDate requestVisitedDate() {
        return new RequestVisitedDateController().process();
    }

    private Orders requestOrders() {
        return new RequestOrdersController().process();
    }

    private UserInformation createUserInformation(VisitedDate visitedDate, Orders orders) {
        return new CreateUserInformationController(visitedDate, orders).process();
    }

    private void displayOrderDetails(UserInformation userInformation) {
        new OrderDetailView(userInformation.getOrderDetails()).process();
    }

    private Benefits calculateBenefits(UserInformation userInformation) {
        return new CalculateBenefitsController(userInformation).proceed();
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