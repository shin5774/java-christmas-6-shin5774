package christmas;

public class TotalOrderAmount {
    private static final int MINIMUM_PROMOTION_AMOUNT = 10000;
    private final int amount;

    private TotalOrderAmount(int amount) {
        this.amount = amount;
    }

    public static TotalOrderAmount from(int amount) {
        return new TotalOrderAmount(amount);
    }

    public boolean canApplyPromotion() {
        return amount >= MINIMUM_PROMOTION_AMOUNT;
    }
}
