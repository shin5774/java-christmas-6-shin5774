package christmas.domain;

import java.util.List;
import java.util.Map;

public class UserInformation {
    private static final int NOT_APPLY_PROMOTION_PRICE = 0;
    private final VisitedDate visitedDate;
    private final Orders orders;

    private UserInformation(VisitedDate visitedDate, Orders orders) {
        this.visitedDate = visitedDate;
        this.orders = orders;
    }

    public static UserInformation of(VisitedDate visitedDate, Orders orders) {
        return new UserInformation(visitedDate, orders);
    }

    public Map<String, Integer> getOrderDetails() {
        return orders.getOrderDetails();
    }

    public Benefits getBenefits() {
        Map<String, Integer> benefits = GiveawayEvent.getGiveawayEventPriceResult(
                orders.getTotalOrderPrice());

        if (orders.canApplyPromotion()) {
            addBenefits(benefits);
        }

        return Benefits.from(benefits);
    }

    private void addBenefits(Map<String, Integer> benefits) {
        List<Promotion> promotions = Promotion.findPromotions(visitedDate.getDate());

        promotions.stream()
                .map(promotion -> Map.entry(promotion.getTitle(),
                        promotion.getDiscountPrice(visitedDate.getDate(),
                                orders.getMenuGroupAmount(promotion.getDiscountMenuGroup()))))
                .filter(benefit -> benefit.getValue() != NOT_APPLY_PROMOTION_PRICE)
                .forEach(benefit -> benefits.put(benefit.getKey(), benefit.getValue()));
    }
}
