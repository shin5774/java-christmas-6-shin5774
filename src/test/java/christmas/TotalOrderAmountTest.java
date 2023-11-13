package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TotalOrderAmountTest {
    @DisplayName("프로모션 참가 가능여부 확인기능")
    @ParameterizedTest
    @CsvSource(value = {"5000:false", "15000:true"}, delimiter = ':')
    void 프로모션_참가가능_확인(int amount, boolean expected) {
        TotalOrderAmount totalOrderAmount = TotalOrderAmount.from(amount);
        assertThat(totalOrderAmount.canApplyPromotion()).isEqualTo(expected);
    }
}
