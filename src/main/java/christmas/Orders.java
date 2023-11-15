package christmas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orders {
    private final Map<Menu, Integer> orders;

    private Orders(Map<Menu, Integer> orders) {
        this.orders = orders;
    }

    public static Orders of(Map<Menu, Integer> orders) {
        return new Orders(orders);
    }

    public int getTotalOrderAmount() {
        return orders.keySet().stream()
                .mapToInt(menu -> menu.getPrice() * orders.get(menu))
                .sum();
    }

    public Map<String, Integer> getOrderDetails() {
        Map<String, Integer> orderDetails = new HashMap<>();

        orders.keySet()
                .forEach(menu -> orderDetails.put(menu.getName(), orders.get(menu)));

        return orderDetails;
    }

    public boolean haveGiveawayMenu() {
        return orders.containsKey(Menu.CHAMPAGNE);
    }

    public Benefits getBenefits(VisitedDate visitedDate, Map<String, Integer> inputBenefits) {
        List<Promotion> applyPromotions = Promotion.findPromotions(visitedDate.getDate());

        applyPromotions.forEach(
                promotion -> inputBenefits.put(promotion.getTitle(),
                        promotion.getDiscountAmount(visitedDate.getDate(), orders))
        );

        return Benefits.from(inputBenefits);
    }

    public int getAfterOrderPrice(Benefits benefits) {
        int beforeOrderPrice = getTotalOrderAmount();
        int totalBenefitPrice = benefits.getTotalBenefitAmount();

        if (isNotApplyGiveawayEventToDiscount(benefits)) {
            totalBenefitPrice -= benefits.getGiveawayEventPrice();
        }

        return Math.max(beforeOrderPrice + totalBenefitPrice, 0);
    }

    private boolean isNotApplyGiveawayEventToDiscount(Benefits benefits) {
        return !(haveGiveawayMenu() && benefits.hasGiveawayEvent());
    }
}
