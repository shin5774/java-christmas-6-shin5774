package christmas.domain;

import static christmas.domain.constant.Constant.GIVEAWAY_EVENT_ITEMS;

import java.util.HashMap;
import java.util.Map;

public class Orders {
    private static final int MINIMUM_PROMOTION_AMOUNT = 10000;
    private static final int NOT_ORDER_MENU_AMOUNT = 0;
    private final Map<Menu, Integer> orders;

    private Orders(Map<Menu, Integer> orders) {
        this.orders = orders;
    }

    public static Orders from(Map<Menu, Integer> orders) {
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

    public int getMenuGroupAmount(MenuGroup menuGroup) {
        return orders.keySet().stream()
                .filter(menuGroup::isContain)
                .mapToInt(orders::get)
                .sum();
    }

    //주문 목록중 증정 메뉴에 일부 포함되어 있는 메뉴들의 가격들의 총합
    public int getSomeContainMenusPrice() {
        return GIVEAWAY_EVENT_ITEMS.keySet().stream()
                .filter(menu -> orders.getOrDefault(menu, NOT_ORDER_MENU_AMOUNT) >= GIVEAWAY_EVENT_ITEMS.get(menu))
                .mapToInt(menu -> menu.getPrice() * (orders.get(menu) - GIVEAWAY_EVENT_ITEMS.get(menu)))
                .sum();
    }

    // 주문 목록중 증정 메뉴에 포함되지 않는 메뉴들의 가격들의 총합
    public int getNotContainMenusPrice() {
        return GIVEAWAY_EVENT_ITEMS.keySet().stream()
                .filter(menu -> !orders.containsKey(menu))
                .mapToInt(menu -> menu.getPrice() * GIVEAWAY_EVENT_ITEMS.get(menu))
                .sum();
    }
}
