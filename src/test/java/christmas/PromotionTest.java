package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PromotionTest {
    @DisplayName("크리스마스 디데이 할인 적용 날짜인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "13:true", "25:true", "26:false", "31:false"}, delimiter = ':')
    void 크리스마스_특별할인_적용여부(int day, boolean expected) {
        Promotion promotion = new Promotion();
        assertThat(promotion.isChristMasDiscount(day)).isEqualTo(expected);
    }
}
