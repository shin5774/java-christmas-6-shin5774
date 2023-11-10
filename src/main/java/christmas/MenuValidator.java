package christmas;

public class MenuValidator {
    private static final int MINIMUM_ORDER_AMOUNT = 1;

    public static void validate(MenuAndAmount menuAndAmount) {
        amountNumberValidate(menuAndAmount.amount());
        amountMinimunValidate(Integer.parseInt(menuAndAmount.amount()));
    }

    private static void amountNumberValidate(String amount) {
        if (Validator.isNotNumber(amount)) {
            throw new IllegalArgumentException();
        }
    }

    private static void amountMinimunValidate(int amount) {
        if (amount < MINIMUM_ORDER_AMOUNT) {
            throw new IllegalArgumentException();
        }
    }

}
