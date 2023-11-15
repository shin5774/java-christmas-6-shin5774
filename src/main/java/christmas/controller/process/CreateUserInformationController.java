package christmas.controller.process;

import christmas.domain.Orders;
import christmas.domain.UserInformation;
import christmas.domain.VisitedDate;

public class CreateUserInformationController {
    private final VisitedDate visitedDate;
    private final Orders orders;

    public CreateUserInformationController(VisitedDate visitedDate, Orders orders) {
        this.visitedDate = visitedDate;
        this.orders = orders;
    }

    public UserInformation proceed() {
        return new UserInformation(visitedDate, orders);
    }
}
