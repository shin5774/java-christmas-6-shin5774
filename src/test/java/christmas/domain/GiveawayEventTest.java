package christmas.domain;

import static christmas.domain.constant.Constant.GIVEAWAY_EVENT_ITEMS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GiveawayEventTest {
    @DisplayName("증정이벤트 결과 반환기능_참가")
    @Test
    void 증정이벤트_참가() {
        int expected = GIVEAWAY_EVENT_ITEMS.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();

        assertThat(GiveawayEvent.getGiveawayEventPriceResult(170000).get("증정 이벤트")).isEqualTo(-expected);
        assertThat(GiveawayEvent.getGiveawayEventMenuResult(170000).isEmpty()).isEqualTo(false);
    }

    @DisplayName("증정이벤트 결과 반환기능_미참가")
    @Test
    void 증정이벤트_미참가() {
        assertThat(GiveawayEvent.getGiveawayEventPriceResult(3000).isEmpty()).isEqualTo(true);
        assertThat(GiveawayEvent.getGiveawayEventMenuResult(3000).isEmpty()).isEqualTo(true);
    }
}
