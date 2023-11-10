package christmas;

import java.util.List;

public class MenusValidator {
    public static void validate(List<MenuAndAmount> menus) {
        duplicateMenuValidate(menus);
    }

    private static void duplicateMenuValidate(List<MenuAndAmount> menus) {
        int uniqueCount = (int) menus.stream()
                .map(MenuAndAmount::menu)
                .distinct().count();

        if (menus.size() != uniqueCount) {
            throw new IllegalArgumentException();
        }
    }
}
