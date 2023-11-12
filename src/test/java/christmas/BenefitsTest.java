package christmas;

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
        benefits.put("혜택1", 1);
        benefits.put("혜택2", 2);
        benefits.put("혜택3", 3);
        benefits.put("혜택4", 4);
        benefits.put("혜택5", 5);
        Benefits result = Benefits.from(benefits);

        assertThat(result.getTotalBenefitAmount).isEqualTo(15);
    }

}
