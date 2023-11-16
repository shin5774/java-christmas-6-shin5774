package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.Badge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BadgeTest {
    @DisplayName("뱃지 반환 기능")
    @ParameterizedTest
    @CsvSource(value = {"3000:없음", "7000:별", "13000:트리", "25000:산타"}, delimiter = ':')
    void 뱃지_반환(int benefitAmount, String expected) {
        Badge badge = Badge.findBadge(benefitAmount);

        assertThat(badge.getName()).isEqualTo(expected);
    }
}
