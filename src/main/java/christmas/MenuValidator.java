package christmas;

import christmas.exception.MenuException;

public class MenuValidator {
    private static final int MINIMUM_ORDER_AMOUNT = 1;

    public static void validate(MenuAndAmount menuAndAmount) {
        menuExistValidate(menuAndAmount.menu());
        amountNumberValidate(menuAndAmount.amount());
        amountMinimunValidate(Integer.parseInt(menuAndAmount.amount()));
    }

    private static void menuExistValidate(String menu) {
        if (Menu.findMenu(menu) == Menu.NONE) {
            throw MenuException.from("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void amountNumberValidate(String amount) {
        if (Validator.isNotNumber(amount)) {
            throw MenuException.from("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void amountMinimunValidate(int amount) {
        if (amount < MINIMUM_ORDER_AMOUNT) {
            throw MenuException.from("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

}
