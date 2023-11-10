package christmas;

public class MenuValidator {
    public static void validate(MenuAndAmount menuAndAmount) {
        amountNumberValidate(menuAndAmount.amount());
    }

    private static void amountNumberValidate(String amount) {
        if (Validator.isNotNumber(amount)) {
            throw new IllegalArgumentException();
        }
    }

}
