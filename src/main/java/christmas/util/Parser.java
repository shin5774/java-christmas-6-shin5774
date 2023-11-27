package christmas.util;

import christmas.dto.MenuAndAmount;
import christmas.exception.MenuException;
import java.util.List;

public class Parser {
    private static final String MENUS_SEPARATOR = ",";
    private static final String MENU_AMOUNT_SEPARATOR = "-";
    private static final int MENU_AMOUNT_SET_SIZE = 2;
    private static final int MENU_INDEX = 0;
    private static final int AMOUNT_INDEX = 1;

    public static List<String> parseMenus(String requestMenus) {
        return parseBySeparator(requestMenus, MENUS_SEPARATOR);
    }

    public static MenuAndAmount parseMenuAndAmount(String requestMenu) {
        if (canNotSeparateMenuAndAmount(requestMenu)) {
            throw MenuException.occur();
        }

        List<String> menuAndAmount = parseBySeparator(requestMenu, MENU_AMOUNT_SEPARATOR);
        if (menuAndAmount.size() < MENU_AMOUNT_SET_SIZE) {
            throw MenuException.occur();
        }

        return new MenuAndAmount(menuAndAmount.get(MENU_INDEX), menuAndAmount.get(AMOUNT_INDEX));
    }

    private static boolean canNotSeparateMenuAndAmount(String requestMenu) {
        return !requestMenu.contains(MENU_AMOUNT_SEPARATOR);
    }

    private static List<String> parseBySeparator(String target, String seperator) {
        return List.of(target.split(seperator));
    }

}
