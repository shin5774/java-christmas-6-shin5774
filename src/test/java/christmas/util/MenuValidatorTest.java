package christmas.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import christmas.dto.MenuAndAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("메뉴에 대한 검증 기능")
public class MenuValidatorTest {
    @DisplayName("메뉴판에 없는 메뉴를 입력받는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"a-1", "없음-2", "돼지국밥-15"})
    void 없는메뉴(String requestMenu) {
        MenuAndAmount menuAndAmount = Parser.parseMenuAndAmount(requestMenu);
        assertThatThrownBy(() -> MenuValidator.validate(menuAndAmount)).isInstanceOf(
                IllegalArgumentException.class);
    }


    @Nested
    @DisplayName("메뉴 수량의 예외처리")
    class AmountException {
        @DisplayName("숫자가 아닌 수량입력값")
        @ParameterizedTest
        @ValueSource(strings = {"a-a", "a-", "1-a", "-a"})
        void 문자입력(String requestMenu) {
            assertThatThrownBy(() -> {
                MenuAndAmount menuAndAmount = Parser.parseMenuAndAmount(requestMenu);
                MenuValidator.validate(menuAndAmount);
            }).isInstanceOf(
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

    @DisplayName("메뉴의 정상입력")
    @ParameterizedTest
    @ValueSource(strings = {"아이스크림-2", "샴페인-3", "양송이수프-1"})
    void 메뉴_정상_입력(String requestMenu) {
        MenuAndAmount menuAndAmount = Parser.parseMenuAndAmount(requestMenu);
        assertDoesNotThrow(() -> {
            MenuValidator.validate(menuAndAmount);
        });
    }
}
