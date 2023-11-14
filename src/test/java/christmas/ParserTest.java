package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParserTest {
    @DisplayName("메뉴와 수량 구분이 안될경우(작대기(-)가 없는경우) 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"aa", "a1", "a/1", "1a"})
    void 메뉴_수량_구분_테스트_예외처리(String menu) {
        assertThatThrownBy(() -> Parser.parseMenuAndAmount(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴와 수량값이 완전하게 들어오지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"-", "--", "---", "1-", "a-"})
    void 메뉴_수량_구분_테스트_비정상_구분(String menu) {
        assertThatThrownBy(() -> Parser.parseMenuAndAmount(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴와 수량 구분 정상처리")
    @ParameterizedTest
    @ValueSource(strings = {"a-a", "a-1", "1-a", "1-1"})
    void 메뉴_수량_구분_테스트_정상처리(String menu) {
        assertDoesNotThrow(() -> Parser.parseMenuAndAmount(menu));
    }
}
