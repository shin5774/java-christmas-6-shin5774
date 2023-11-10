package christmas;

import java.util.Arrays;
import java.util.List;

public enum MenuGroup {
    APPETIZER(List.of(Menu.MUSHROOM_SOUP, Menu.TAPAS, Menu.CAESAR_SALAD)),
    MAIN(List.of(Menu.T_BORN_STEAK, Menu.BARBECUE_RIB, Menu.SEAFOOD_PASTA, Menu.CHRISTMAS_PASTA)),
    DESSERT(List.of(Menu.CHOCOLATE_CAKE, Menu.ICE_CREAM)),
    BEVERAGE(List.of(Menu.ZERO_COKE, Menu.RED_WINE, Menu.CHAMPAGNE)),
    NONE(List.of());

    private final List<Menu> menus;

    MenuGroup(List<Menu> menus) {
        this.menus = menus;
    }

    public static MenuGroup findGroup(Menu menu) {
        return Arrays.stream(MenuGroup.values())
                .filter(menuGroup -> menuGroup.isContain(menu))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isContain(Menu menu) {
        return menus.contains(menu);
    }
}
