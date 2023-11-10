package christmas;

import java.util.List;

public class Parser {
    private static final String MENUS_SEPERATOR = ",";
    private static final String MENU_AMOUNT_SEPERATOR = "-";

    public static List<String> parseBySeperator(String target, String seperator) {
        return List.of(target.split(seperator));
    }

    public static List<String> parseMenus(String requestMenus) {
        return parseBySeperator(requestMenus, MENUS_SEPERATOR);
    }

    public static MenuAndAmount parseMenuAndAmount(String requestMenu) {
        List<String> menuAndAmount = parseBySeperator(requestMenu, MENU_AMOUNT_SEPERATOR);

        if (menuAndAmount.size() == 2) {
            return new MenuAndAmount(menuAndAmount.get(0), menuAndAmount.get(1));
        }
        return new MenuAndAmount(menuAndAmount.get(0), "");
    }
}
