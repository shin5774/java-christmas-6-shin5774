package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BenefitsTest {
    private static final Benefits benefits = null;

    @BeforeAll
    static void 초기설정() {
        Map<String, Integer> benefitsData = new HashMap<>();
        benefitsData.put("크리스마스 디데이 할인", 1);
        benefitsData.put("평일 할인", 2);
        benefitsData.put("주말 할인", 3);
        benefitsData.put("특별 할인", 4);
        benefitsData.put("증정 이벤트", 5);
        Benefits result = Benefits.from(benefitsData);
    }

    @DisplayName("총 혜택금액 반환 기능")
    @Test
    void 총_혜택금액() {
        assertThat(benefits.getTotalBenefitAmount()).isEqualTo(15);
    }

    @DisplayName("할인후 예상 결제 금액 반환기능_정상적_처리")
    @Test
    void 예상_결제액_정상값() {
        //given
        int chargeAmont = 25;
        assertThat(benefits.getExpectedPayAmount(chargeAmont)).isEqualTo(10);
    }


}
