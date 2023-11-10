package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("메뉴에 대한 검증 기능")
public class MenuValidatorTest {

    @Nested
    @DisplayName("메뉴 수량의 예외처리")
    class AmountException {
        @DisplayName("숫자가 아닌 수량입력값")
        @ParameterizedTest
        @ValueSource(strings = {"a-a", "a-", "1-a"})
        void 문자입력(String requestMenu) {
            MenuAndAmount menuAndAmount = Parser.parseMenuAndAmount(requestMenu);
            assertThatThrownBy(() -> MenuValidator.validate(menuAndAmount)).isInstanceOf(
                    IllegalArgumentException.class);
        }

        @DisplayName("1 미만의 수량입력값")
        @ParameterizedTest
        @ValueSource(strings = {"a-0", "a--3"})
        void 주문최소량_미만(String requestMenu) {
            MenuAndAmount menuAndAmount = Parser.parseMenuAndAmount(requestMenu);
            assertThatThrownBy(() -> MenuValidator.validate(menuAndAmount)).isInstanceOf(
                    IllegalArgumentException.class);
        }
    }
}
