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
        VisitedDate visitedDate = requestVisitedDate();
        Orders orders = requestOrders();

        outputView.printOrderDetails(orders.getOrderDetails());

        TotalOrderAmount totalOrderAmount = TotalOrderAmount.from(orders.getTotalOrderAmount());

        Benefits benefits = Benefits.from(new HashMap<>());
        boolean isGiveawayEvent = totalOrderAmount.canApplyGiveawayEvent();
        String giveawayEvent = getGiveawayResult(isGiveawayEvent);

        if (totalOrderAmount.canApplyPromotion()) {
            benefits = orders.getBenefits(visitedDate, isGiveawayEvent);
        }

        int totalBenefitsAmount = benefits.getTotalBenefitAmount();

        outputView.printTotalOrderAmount(totalOrderAmount.toString());
        outputView.printGiveawayEvent(giveawayEvent);
        outputView.printBenefits(benefits.getBenefitDetails());
        outputView.printTotalBenefitsAmount(Integer.toString(totalBenefitsAmount));
        outputView.printExpectedPayAmount(
                Integer.toString(totalOrderAmount.getExpectedPayAmount(benefits.getActualDiscountAmount(orders))));
        outputView.printBadge(Badge.findBadge(-totalBenefitsAmount).getName());
    }

    private String getGiveawayResult(boolean isGiveawayEvent) {
        if (isGiveawayEvent) {
            return "샴페인 1개";
        }
        return "없음";
    }

    private VisitedDate requestVisitedDate() {
        while (true) {
            try {
                VisitedDateDTO visitedDateDTO = inputView.requestVisitedDate();
                return visitedDateDTO.toVisitedDate();
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception.getMessage());
            }
        }
    }

    private Orders requestOrders() {
        while (true) {
            try {
                List<MenuAndAmount> requestOrders = inputView.requestOrders();
                MenusValidator.validate(requestOrders);

                Map<Menu, Integer> inputOrders = new EnumMap<>(Menu.class);
                requestOrders.forEach(
                        order -> inputOrders.put(Menu.findMenu(order.menu()), Integer.parseInt(order.amount())));
                return Orders.of(inputOrders);
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception.getMessage());
            }
        }
    }
}
