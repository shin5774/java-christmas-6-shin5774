package christmas;

public class TotalOrderAmount {
    private static final int MINIMUM_PROMOTION_AMOUNT = 10000;
    private static final int MINIMUM_GIVEAWAY_EVENT_AMOUNT = 120000;
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

    public boolean canApplyGiveawayEvent() {
        return amount >= MINIMUM_GIVEAWAY_EVENT_AMOUNT;
    }

    public int getExpectedPayAmount(int actualDiscountAmount) {
        return Math.max(amount + actualDiscountAmount, 0);
    }

    public String toString() {
        return Integer.toString(amount);
    }

    public int getAmount() {
        return amount;
    }
}
