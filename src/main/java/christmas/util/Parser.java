package christmas.util;

import christmas.dto.MenuAndAmount;
import christmas.exception.MenuException;
import java.util.List;

public class Parser {
    private static final String MENUS_SEPERATOR = ",";
    private static final String MENU_AMOUNT_SEPERATOR = "-";
    private static final int MENU_AMOUNT_SET_SIZE = 2;

    public static List<String> parseMenus(String requestMenus) {
        return parseBySeperator(requestMenus, MENUS_SEPERATOR);
    }

    public static MenuAndAmount parseMenuAndAmount(String requestMenu) {
        if (canNotSeprateMenuAndAmount(requestMenu)) {
            throw MenuException.occur();
        }

        List<String> menuAndAmount = parseBySeperator(requestMenu, MENU_AMOUNT_SEPERATOR);
        if (menuAndAmount.size() < MENU_AMOUNT_SET_SIZE) {
            throw MenuException.occur();
        }

        return new MenuAndAmount(menuAndAmount.get(0), menuAndAmount.get(1));
    }

    private static boolean canNotSeprateMenuAndAmount(String requestMenu) {
        return !requestMenu.contains(MENU_AMOUNT_SEPERATOR);
    }

    private static List<String> parseBySeperator(String target, String seperator) {
        return List.of(target.split(seperator));
    }

}
