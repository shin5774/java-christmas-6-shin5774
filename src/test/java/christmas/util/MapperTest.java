package christmas.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import christmas.dto.VisitedDateDTO;
import christmas.util.Mapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MapperTest {
    @Nested
    @DisplayName("방문날짜 입력에 대한 Mapper")
    class VisitedDateMapper {
        @Nested
        @DisplayName("예외처리 로직")
        class toDto {
            @DisplayName("숫자가 아닌값")
            @ParameterizedTest
            @ValueSource(strings = {"a", "1a", "", "a1"})
            void 문자입력(String request) {
                assertThatThrownBy(() -> {
                            Mapper.toVisitedDateDTO(request);
                        }
                ).isInstanceOf(IllegalArgumentException.class);
            }

            @DisplayName("1이상 31이하의 숫자 입력값")
            @ParameterizedTest
            @ValueSource(strings = {"0", "-5", "35"})
            void 범위초과입력(String request) {
                assertThatThrownBy(() -> {
                            VisitedDateDTO visitedDateDTO = Mapper.toVisitedDateDTO(request);
                            Mapper.toVisitedDate(visitedDateDTO);
                        }
                ).isInstanceOf(IllegalArgumentException.class);
            }
        }

        @DisplayName("방문 날짜 입력 기능의 정상동작")
        @ParameterizedTest
        @ValueSource(strings = {"1", "15", "23", "31"})
        void 입력_정상동작(String request) {
            assertDoesNotThrow(() -> {
                VisitedDateDTO visitedDateDTO = Mapper.toVisitedDateDTO(request);
                Mapper.toVisitedDate(visitedDateDTO);
            });
        }
    }
}
