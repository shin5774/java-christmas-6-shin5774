package christmas.domain;

import java.util.Map;

public class UserInformation {
    private final VisitedDate visitedDate;
    private final Orders orders;

    public UserInformation(VisitedDate visitedDate, Orders orders) {
        this.visitedDate = visitedDate;
        this.orders = orders;
    }

    public Map<String, Integer> getOrderDetails() {
        return orders.getOrderDetails();
    }

    public Benefits getBenefits() {
        Map<String, Integer> giveawayEventResult = GiveawayEvent.getGiveawayEventPriceResult(
                orders.getTotalOrderPrice());

        if (orders.canApplyPromotion()) {
            return orders.getBenefits(visitedDate, giveawayEventResult);
        }

        return Benefits.from(giveawayEventResult);
    }

}
