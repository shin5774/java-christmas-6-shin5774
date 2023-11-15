package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.Menu;
import christmas.domain.Promotion;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PromotionTest {
    @DisplayName("날짜별 프로모션 적용목록둘울 반환한다.")
    @MethodSource("dayAndPromotions")
    @ParameterizedTest(name = "날짜 : {0}일, 프로모션 적용목록: {1}")
    void 프로모션_적용_목록확인(int day, List<Promotion> expected) {
        List<Promotion> promotions = Promotion.findPromotions(day);
        promotions.forEach(promotion -> assertThat(expected.contains(promotion)).isTrue());
    }

    @DisplayName("프로모션별 할인 금액을 반환한다.")
    @MethodSource("promotionAndDayAndDiscountAmount")
    @ParameterizedTest(name = "프로모션 : {0}, 날짜 : {1}, 예상 할인금액: {2}")
    void 할인_금액_반환(Promotion promotion, int day, int discountAmount) {
        Map<Menu, Integer> order = new EnumMap<>(Menu.class);
        Arrays.stream(Menu.values()).forEach(menu -> order.put(menu, 1));

        assertThat(promotion.getDiscountAmount(day, order)).isEqualTo(discountAmount);
    }

    static Stream<Arguments> dayAndPromotions() {
        return Stream.of(
                Arguments.arguments(1, List.of(Promotion.WEEKEND, Promotion.CHRISTMAS_D_DAY)),
                Arguments.arguments(3, List.of(Promotion.WEEKDAY, Promotion.CHRISTMAS_D_DAY, Promotion.SPECIAL)),
                Arguments.arguments(7, List.of(Promotion.WEEKDAY, Promotion.CHRISTMAS_D_DAY)),
                Arguments.arguments(25, List.of(Promotion.WEEKDAY, Promotion.CHRISTMAS_D_DAY, Promotion.SPECIAL)),
                Arguments.arguments(26, List.of(Promotion.WEEKDAY)),
                Arguments.arguments(29, List.of(Promotion.WEEKEND)),
                Arguments.arguments(31, List.of(Promotion.WEEKDAY, Promotion.SPECIAL))
        );
    }

    static Stream<Arguments> promotionAndDayAndDiscountAmount() {
        return Stream.of(
                Arguments.arguments(Promotion.CHRISTMAS_D_DAY, 3, -1200),
                Arguments.arguments(Promotion.WEEKDAY, 4, -4046),
                Arguments.arguments(Promotion.WEEKEND, 6, -8092),
                Arguments.arguments(Promotion.SPECIAL, 3, -1000)
        );
    }
}
