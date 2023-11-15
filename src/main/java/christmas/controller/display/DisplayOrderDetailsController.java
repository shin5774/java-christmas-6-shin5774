package christmas.controller.display;

import christmas.domain.UserInformation;
import christmas.view.display.OrderDetailView;
import java.util.Map;

public class DisplayOrderDetailsController implements DisplayController {
    private final UserInformation userInformation;

    public DisplayOrderDetailsController(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    @Override
    public void proceed() {
        Map<String, Integer> orderDetails = userInformation.getOrderDetails();
        new OrderDetailView(orderDetails).proceed();
    }
}
