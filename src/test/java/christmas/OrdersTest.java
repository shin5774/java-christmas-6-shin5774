package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrdersTest {
    @DisplayName("주문 메뉴들의 가격의 합을 구하는 기능")
    @Test
    void 할인전_총_주문_금액_반환() {
        Map<Menu, Integer> order = new EnumMap<>(Menu.class);
        Arrays.stream(Menu.values()).forEach(menu -> order.put(menu, 1));
        Orders orders = Orders.of(order);
        assertThat(orders.getTotalOrderAmount()).isEqualTo(296500);
    }
}
