package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.Benefits;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BenefitsTest {
    private static Benefits benefits;

    @BeforeAll
    static void 초기설정() {
        Map<String, Integer> benefitsData = new HashMap<>();
        benefitsData.put("크리스마스 디데이 할인", -1);
        benefitsData.put("평일 할인", -2);
        benefitsData.put("주말 할인", -3);
        benefitsData.put("특별 할인", -4);
        benefitsData.put("증정 이벤트", -5);
        benefits = Benefits.from(benefitsData);
    }

    @DisplayName("총 혜택금액 반환 기능")
    @Test
    void 총_할인금액() {
        assertThat(benefits.getTotalBenefitAmount()).isEqualTo(-15);
    }
}
