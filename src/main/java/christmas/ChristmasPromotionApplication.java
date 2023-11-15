package christmas;

import christmas.controller.display.DisplayAfterOrderPriceController;
import christmas.controller.display.DisplayBadgeController;
import christmas.controller.display.DisplayBeforeOrderPriceController;
import christmas.controller.display.DisplayBenefitDetailsController;
import christmas.controller.display.DisplayGiveawayMenuController;
import christmas.controller.display.DisplayTotalBenefitPriceController;
import christmas.controller.display.MessageController;
import christmas.controller.process.CalculateBenefitsController;
import christmas.controller.process.CreateUserInformationController;
import christmas.controller.request.RequestOrdersController;
import christmas.controller.request.RequestVisitedDateController;
import christmas.domain.Benefits;
import christmas.domain.Orders;
import christmas.domain.UserInformation;
import christmas.domain.VisitedDate;
import christmas.view.display.OrderDetailView;

public class ChristmasPromotionApplication {
    private final MessageController messageController;

    public ChristmasPromotionApplication(MessageController messageController) {
        this.messageController = messageController;
    }

    public void start() {
        messageController.displayPlaanerStartMessage();
        VisitedDate visitedDate = requestVisitedDate();
        Orders orders = requestOrders();
        UserInformation userInformation = createUserInformation(visitedDate, orders);

        messageController.displayResultStartMessage();
        displayOrderDetails(userInformation);
        Benefits benefits = calculateBenefits(userInformation);
        printResult(benefits, orders);
    }


    private VisitedDate requestVisitedDate() {
        return new RequestVisitedDateController().proceed();
    }

    private Orders requestOrders() {
        return new RequestOrdersController().proceed();
    }

    private UserInformation createUserInformation(VisitedDate visitedDate, Orders orders) {
        return new CreateUserInformationController(visitedDate, orders).proceed();
    }

    private void displayOrderDetails(UserInformation userInformation) {
        new OrderDetailView(userInformation.getOrderDetails()).proceed();
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
        new DisplayBeforeOrderPriceController(orders).proceed();
    }

    private void displayGiveawayMenu(Orders orders) {
        new DisplayGiveawayMenuController(orders).proceed();
    }

    private void displayBenefitDetails(Benefits benefits) {
        new DisplayBenefitDetailsController(benefits).proceed();
    }

    private void displayTotalBenefitPrice(Benefits benefits) {
        new DisplayTotalBenefitPriceController(benefits).proceed();
    }

    private void displayAfterOrderPrice(Orders orders, Benefits benefits) {
        new DisplayAfterOrderPriceController(orders, benefits).proceed();
    }

    private void displayBadge(Benefits benefits) {
        new DisplayBadgeController(benefits).proceed();
    }
}