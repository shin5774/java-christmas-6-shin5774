package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrdersTest {
    private static Orders orders;

    @BeforeAll
    static void 초기설정() {
        Map<Menu, Integer> order = new EnumMap<>(Menu.class);
        Arrays.stream(Menu.values())
                .filter(menu -> !menu.equals(Menu.NONE))
                .forEach(menu -> order.put(menu, 1));
        orders = Orders.of(order);
    }

    @DisplayName("주문 메뉴들의 가격의 합을 구하는 기능")
    @Test
    void 할인전_총_주문_금액_반환() {
        assertThat(orders.getTotalOrderAmount()).isEqualTo(296500);
    }

    @DisplayName("주문 메뉴의 이름과 개수를 반환해주는 기능")
    @Test
    void 주문_반환() {
        List<String> menuNames = Arrays.stream(Menu.values())
                .map(Menu::getName)
                .toList();

        orders.getOrderDetails().keySet()
                .forEach(menu -> assertThat(menuNames.contains(menu)).isTrue());
    }

    @DisplayName("프로모션 참가 가능여부 확인기능_참가")
    @Test
    void 프로모션_참가가능_확인_참가() {
        assertThat(orders.canApplyPromotion()).isEqualTo(true);
    }

    @DisplayName("프로모션 참가 가능여부 확인기능_불참가")
    @Test
    void 프로모션_참가가능_확인_불참() {
        Map<Menu, Integer> orders = new EnumMap<>(Menu.class);
        Orders noOrder = Orders.of(orders);
        assertThat(noOrder.canApplyPromotion()).isEqualTo(false);
    }
}
