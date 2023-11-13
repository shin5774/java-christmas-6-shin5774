package christmas;

import christmas.dto.VisitedDateDTO;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        VisitedDateDTO visitedDateDTO = inputView.requestVisitedDate();
        VisitedDate visitedDate = visitedDateDTO.toVisitedDate();

        List<MenuAndAmount> requestOrders = inputView.requestOrders();
        MenusValidator.validate(requestOrders);

        Map<Menu, Integer> inputOrders = new EnumMap<>(Menu.class);
        requestOrders.forEach(order -> inputOrders.put(Menu.findMenu(order.menu()), Integer.parseInt(order.amount())));
        Orders orders = Orders.of(inputOrders);

        outputView.printOrderDetails(orders.getOrderDetails());
    }
}
