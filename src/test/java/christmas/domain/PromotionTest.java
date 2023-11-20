package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
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
}
