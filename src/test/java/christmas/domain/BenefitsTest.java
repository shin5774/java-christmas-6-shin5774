package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BenefitsTest {
    private static Benefits benefits;

    @BeforeAll
    static void 초기설정() {
        List<Benefit> benefitsData = List.of(
                new Benefit("크리스마스 디데이 할인", -1),
                new Benefit("평일 할인", -2),
                new Benefit("주말 할인", -3),
                new Benefit("특별 할인", -4),
                new Benefit("증정 이벤트", -5)
        );
        benefits = Benefits.from(benefitsData);
    }

    @DisplayName("총 혜택금액 반환 기능")
    @Test
    void 총_할인금액() {
        assertThat(benefits.getTotalBenefitAmount()).isEqualTo(-15);
    }

    @DisplayName("증정 이벤트 혜택 확인_존재")
    @Test
    void 증정_이벤트_존재() {
        assertThat(benefits.hasGiveawayEvent()).isTrue();
    }

    @DisplayName("증정 이벤트 혜택 확인_미존재")
    @Test
    void 증정_이벤트_미존재() {
        List<Benefit> nonBenefitsData = List.of(
                new Benefit("크리스마스 디데이 할인", -1),
                new Benefit("평일 할인", -2),
                new Benefit("주말 할인", -3),
                new Benefit("특별 할인", -4)
        );
        Benefits nonBenefits = Benefits.from(nonBenefitsData);

        assertThat(nonBenefits.hasGiveawayEvent()).isFalse();
    }
}
