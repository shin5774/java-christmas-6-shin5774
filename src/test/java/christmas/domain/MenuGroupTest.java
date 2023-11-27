package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.Menu;
import christmas.domain.MenuGroup;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MenuGroupTest {
    @DisplayName("인자로 온 메뉴의 카테고리를 반환해주는 기능")
    @MethodSource("menusAndMenuGroup")
    @ParameterizedTest(name = "메뉴 그룹 : {0}, 메뉴 목록: {1}")
    void 메뉴_카테고리_반환(MenuGroup menuGroup, List<Menu> menus) {
        menus.forEach(menu -> assertThat(MenuGroup.findGroup(menu)).isEqualTo(menuGroup));
    }

    static Stream<Arguments> menusAndMenuGroup() {
        return Stream.of(
                Arguments.arguments(MenuGroup.APPETIZER, List.of(Menu.MUSHROOM_SOUP, Menu.TAPAS, Menu.CAESAR_SALAD)),
                Arguments.arguments(MenuGroup.MAIN,
                        List.of(Menu.T_BORN_STEAK, Menu.BARBECUE_RIB, Menu.SEAFOOD_PASTA, Menu.CHRISTMAS_PASTA)),
                Arguments.arguments(MenuGroup.DESSERT, List.of(Menu.CHOCOLATE_CAKE, Menu.ICE_CREAM)),
                Arguments.arguments(MenuGroup.BEVERAGE, List.of(Menu.ZERO_COKE, Menu.RED_WINE, Menu.CHAMPAGNE))
        );
    }
}
