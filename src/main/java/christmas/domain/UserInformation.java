package christmas.domain;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Benefit> benefits = new ArrayList<>();

        benefits.add(GiveawayEvent.getGiveawayEventPriceResult(
                orders.getTotalOrderPrice()));

        if (orders.canApplyPromotion()) {
            benefits.addAll(addBenefits());
        }

        benefits.removeAll(Collections.singletonList(null));

        return Benefits.from(benefits);
    }

    private List<Benefit> addBenefits() {
        List<Promotion> promotions = Promotion.findPromotions(visitedDate);

        return promotions.stream()
                .map(promotion -> Map.entry(promotion.getTitle(),
                        promotion.getDiscountPrice(visitedDate.getDate(),
                                orders.getMenuGroupAmount(promotion.getDiscountMenuGroup()))))
                .filter(benefit -> benefit.getValue() != NOT_APPLY_PROMOTION_PRICE)
                .map(benefit -> new Benefit(benefit.getKey(), benefit.getValue()))
                .toList();
    }
}
