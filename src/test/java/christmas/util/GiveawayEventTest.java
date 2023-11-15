package christmas.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.GiveawayEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GiveawayEventTest {
    @DisplayName("증정이벤트 적용여부 확인기능")
    @ParameterizedTest
    @CsvSource(value = {"80000:false", "150000:true"}, delimiter = ':')
    void 증정메뉴_증정여부_확인(int amount, boolean expected) {
        assertThat(GiveawayEvent.canApplyGiveawayEvent(amount)).isEqualTo(expected);
    }

    @DisplayName("증정이벤트 결과 반환기능_참가")
    @Test
    void 증정이벤트_참가() {
        assertThat(GiveawayEvent.getGiveawayEventPriceResult(170000).get("증정 이벤트")).isEqualTo(-25000);
    }

    @DisplayName("증정이벤트 결과 반환기능_미참가")
    @Test
    void 증정이벤트_미참가() {
        assertThat(GiveawayEvent.getGiveawayEventPriceResult(3000).size()).isEqualTo(0);
    }
}
