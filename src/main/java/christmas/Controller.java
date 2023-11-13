package christmas;

import christmas.dto.VisitedDateDTO;
import java.util.EnumMap;
import java.util.HashMap;
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

        TotalOrderAmount totalOrderAmount = TotalOrderAmount.from(orders.getTotalOrderAmount());

        Benefits benefits = Benefits.from(new HashMap<>());
        boolean isGiveawayEvent = totalOrderAmount.canApplyGiveawayEvent();
        String giveawayEvent = getGiveawayResult(isGiveawayEvent);

        if (totalOrderAmount.canApplyPromotion()) {
            benefits = orders.getBenefits(visitedDate, isGiveawayEvent);
        }
    }

    private String getGiveawayResult(boolean isGiveawayEvent) {
        if (isGiveawayEvent) {
            return "샴페인 1개";
        }
        return "없음";
    }
}
