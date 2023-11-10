package christmas.dto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class VisitedDateDTOTest {
    @Nested
    @DisplayName("방문 날짜 입력값의 예외처리 동작")
    class VisitedDateException {
        @DisplayName("숫자가 아닌 입력값")
        @ParameterizedTest
        @ValueSource(strings = {"a", "1a", "", "a1"})
        void 문자입력(String input) {
            assertThatThrownBy(() -> {
                        VisitedDateDTO visitedDateDTO = new VisitedDateDTO(input);
                    }
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("1이상 31이하의 숫자 입력값")
        @ParameterizedTest
        @ValueSource(strings = {"0", "-5", "35"})
        void 범위초과입력(String request) {
            assertThatThrownBy(() -> {
                        VisitedDateDTO visitedDateDTO = new VisitedDateDTO(request);
                        visitedDateDTO.toVisitedDate();
                    }
            ).isInstanceOf(IllegalArgumentException.class);
        }
    }

}
