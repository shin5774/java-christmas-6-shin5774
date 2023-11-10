package christmas;

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
}
