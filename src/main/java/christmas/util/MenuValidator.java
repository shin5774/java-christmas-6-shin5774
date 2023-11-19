package christmas.util;

import christmas.domain.Menu;
import christmas.dto.MenuAndAmount;
import christmas.exception.MenuException;

public class MenuValidator {
    private static final int MINIMUM_ORDER_AMOUNT = 1;

    public static void validate(MenuAndAmount menuAndAmount) {
        menuExistValidate(menuAndAmount.menu());
        amountNumberValidate(menuAndAmount.amount());
        amountMinimumValidate(Integer.parseInt(menuAndAmount.amount()));
    }

    private static void menuExistValidate(String menu) {
        if (Menu.findMenu(menu) == Menu.NONE) {
            throw MenuException.occur();
        }
    }

    private static void amountNumberValidate(String amount) {
        if (Validator.isNotNumber(amount)) {
            throw MenuException.occur();
        }
    }

    private static void amountMinimumValidate(int amount) {
        if (amount < MINIMUM_ORDER_AMOUNT) {
            throw MenuException.occur();
        }
    }

}
