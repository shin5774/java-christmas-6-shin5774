package christmas;

import java.util.List;

public class MenusValidator {
    private static final int AMOUNT_UPPER_LIMIT = 20;

    public static void validate(List<MenuAndAmount> menus) {
        duplicateMenuValidate(menus);
        exceededLimitValidate(menus);
    }

    private static void duplicateMenuValidate(List<MenuAndAmount> menus) {
        int uniqueCount = (int) menus.stream()
                .map(MenuAndAmount::menu)
                .distinct().count();

        if (menus.size() != uniqueCount) {
            throw new IllegalArgumentException();
        }
    }

    private static void exceededLimitValidate(List<MenuAndAmount> menus) {
        int totalAmount = menus.stream()
                .map(MenuAndAmount::amount)
                .mapToInt(Integer::parseInt)
                .sum();

        if (totalAmount > AMOUNT_UPPER_LIMIT) {
            throw new IllegalArgumentException();
        }
    }
}
