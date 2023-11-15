package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @DisplayName("증정이벤트 적용여부 확인기능")
    @ParameterizedTest
    @CsvSource(value = {"80000:false", "150000:true"}, delimiter = ':')
    void 증정메뉴_증정여부_확인(int amount, boolean expected) {
        TotalOrderAmount totalOrderAmount = TotalOrderAmount.from(amount);
        assertThat(totalOrderAmount.canApplyGiveawayEvent()).isEqualTo(expected);
    }

    @DisplayName("증정이벤트 결과 반환기능_참가")
    @Test
    void 증정이벤트_참가() {
        TotalOrderAmount totalOrderAmount = TotalOrderAmount.from(170000);
        assertThat(totalOrderAmount.getGiveawayEventResult().get("증정 이벤트")).isEqualTo(-25000);
    }

    @DisplayName("증정이벤트 결과 반환기능_미참가")
    @Test
    void 증정이벤트_미참가() {
        TotalOrderAmount totalOrderAmount = TotalOrderAmount.from(3000);
        assertThat(totalOrderAmount.getGiveawayEventResult().size()).isEqualTo(0);
    }
}
