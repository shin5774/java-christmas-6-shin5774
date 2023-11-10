package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @DisplayName("할인 금액을 반환한다.")
    @MethodSource("promotionAndDayAndDiscountAmount")
    @ParameterizedTest(name = "프로모션 : {0},날짜 : {1},메뉴 수 : {2},예상 할인금액: {3}")
    void 할인_금액_반환(Promotion promotion, int day, int menuAmount, int discountAmount) {
        assertThat(promotion.getDiscountAmount(day, menuAmount)).isEqualTo(discountAmount);
    }

    @DisplayName("프로모션 할인대상에 해당되는 메뉴들의 개수합을 반환한다.")
    @MethodSource("promotionAndMenuAmount")
    @ParameterizedTest(name = "프로모션 : {0},메뉴 수 : {1}")
    void 프로모션_대상_메뉴수_반환(Promotion promotion, int menuAmount) {
        //given
        Map<Menu, Integer> order = new EnumMap<>(Menu.class);
        Arrays.stream(Menu.values()).forEach(menu -> order.put(menu, 1));

        assertThat(promotion.getDiscountMenuAmount(order)).isEqualTo(menuAmount);
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
                Arguments.arguments(Promotion.CHRISTMAS_D_DAY, 3, 2, 1200),
                Arguments.arguments(Promotion.WEEKDAY, 4, 3, 6069),
                Arguments.arguments(Promotion.WEEKEND, 6, 2, 4046),
                Arguments.arguments(Promotion.SPECIAL, 3, 5, 1000)
        );
    }

    static Stream<Arguments> promotionAndMenuAmount() {
        return Stream.of(
                Arguments.arguments(Promotion.CHRISTMAS_D_DAY, 1),
                Arguments.arguments(Promotion.WEEKDAY, 2),
                Arguments.arguments(Promotion.WEEKEND, 4),
                Arguments.arguments(Promotion.SPECIAL, 1)
        );
    }
}
