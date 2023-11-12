package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BenefitsTest {
    @DisplayName("총 혜택금액 반환 기능")
    @Test
    void 총_혜택금액() {
        //given
        Map<String, Integer> benefits = new HashMap<>();
        benefits.put("크리스마스 디데이 할인", 1);
        benefits.put("평일 할인", 2);
        benefits.put("주말 할인", 3);
        benefits.put("특별 할인", 4);
        benefits.put("증정 이벤트", 5);
        Benefits result = Benefits.from(benefits);

        assertThat(result.getTotalBenefitAmount()).isEqualTo(15);
    }

}
