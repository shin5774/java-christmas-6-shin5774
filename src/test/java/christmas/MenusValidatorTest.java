package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MenusValidatorTest {


    @DisplayName("메뉴들을 예외처리")
    @Nested
    class MenusException {
        @DisplayName("메뉴의 중복 입력 예외처리")
        @Test
        void 메뉴중복입력() {
            List<MenuAndAmount> menus = List.of(new MenuAndAmount("양송이수프", "2"), new MenuAndAmount("초코케이크", "1"),
                    new MenuAndAmount("아이스크림", "3"), new MenuAndAmount("바비큐립", "1"), new MenuAndAmount("양송이수프", "3"));

            assertThatThrownBy(() -> {
                MenusValidator.validate(menus);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("메뉴의 개수 합이 20개 초과입력 예외처리")
        @Test
        void 메뉴개수_상한초과() {
            List<MenuAndAmount> menus = List.of(new MenuAndAmount("양송이수프", "4"), new MenuAndAmount("초코케이크", "6"),
                    new MenuAndAmount("아이스크림", "3"), new MenuAndAmount("바비큐립", "4"), new MenuAndAmount("레드와인", "5"));

            assertThatThrownBy(() -> {
                MenusValidator.validate(menus);
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }


}
