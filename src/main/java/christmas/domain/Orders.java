package christmas.domain;

import static christmas.domain.constant.Constant.GIVEAWAY_EVENT_ITEMS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orders {
    private static final int MINIMUM_PROMOTION_AMOUNT = 10000;
    private static final int MINIMUN_AFTER_ORDER_PRICE = 0;
    private final Map<Menu, Integer> orders;

    private Orders(Map<Menu, Integer> orders) {
        this.orders = orders;
    }

    public static Orders of(Map<Menu, Integer> orders) {
        return new Orders(orders);
    }

    public int getTotalOrderPrice() {
        return orders.keySet().stream()
                .mapToInt(menu -> menu.getPrice() * orders.get(menu))
                .sum();
    }

    public boolean canApplyPromotion() {
        return getTotalOrderPrice() >= MINIMUM_PROMOTION_AMOUNT;
    }

    public Map<String, Integer> getOrderDetails() {
        Map<String, Integer> orderDetails = new HashMap<>();

        orders.keySet()
                .forEach(menu -> orderDetails.put(menu.getName(), orders.get(menu)));

        return orderDetails;
    }

    public Benefits getBenefits(VisitedDate visitedDate, Map<String, Integer> inputBenefits) {
        List<Promotion> applyPromotions = Promotion.findPromotions(visitedDate.getDate());

        applyPromotions.forEach(
                promotion -> inputBenefits.put(promotion.getTitle(),
                        promotion.getDiscountPrice(visitedDate.getDate(), orders))
        );

        return Benefits.from(inputBenefits);
    }

    public int getAfterOrderPrice(Benefits benefits) {
        int beforeOrderPrice = getTotalOrderPrice();
        int totalBenefitPrice = benefits.getTotalBenefitAmount();

        if (benefits.hasGiveawayEvent()) {
            totalBenefitPrice += getExceptBenefitPrice();
        }

        return Math.max(beforeOrderPrice + totalBenefitPrice, MINIMUN_AFTER_ORDER_PRICE);
    }

    private int getExceptBenefitPrice() {
        // 주문 목록중 증정 메뉴에 포함되지 않는 메뉴들의 가격들의 총합
        int notContainMenusPrice = GIVEAWAY_EVENT_ITEMS.keySet().stream()
                .filter(menu -> !orders.containsKey(menu))
                .mapToInt(menu -> menu.getPrice() * GIVEAWAY_EVENT_ITEMS.get(menu))
                .sum();
        //주문 목록중 증정 메뉴에 일부 포함되어 있는 메뉴들의 가격들의 총합
        int someContainMenusPrice = GIVEAWAY_EVENT_ITEMS.keySet().stream()
                .filter(menu -> orders.getOrDefault(menu, 0) >= GIVEAWAY_EVENT_ITEMS.get(menu))
                .mapToInt(menu -> menu.getPrice() * (orders.get(menu) - GIVEAWAY_EVENT_ITEMS.get(menu)))
                .sum();

        return notContainMenusPrice + someContainMenusPrice;
    }
}
