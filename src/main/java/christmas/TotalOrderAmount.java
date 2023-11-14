package christmas;

import java.util.HashMap;
import java.util.Map;

public class TotalOrderAmount {
    private static final int MINIMUM_PROMOTION_AMOUNT = 10000;
    private static final int MINIMUM_GIVEAWAY_EVENT_AMOUNT = 120000;
    private static final String GIVEAWAY_EVENT_TITLE = "증정 이벤트";
    private static final Map<Menu, Integer> GIVEAWAY_EVENT_ITEMS = Map.of(Menu.CHAMPAGNE, 1);
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

    public int getAmount() {
        return amount;
    }

    public Map<String, Integer> getGiveawayEventResult() {
        Map<String, Integer> giveawayResult = new HashMap<>();

        if (canApplyGiveawayEvent()) {
            int totalEventPrice = -GIVEAWAY_EVENT_ITEMS.entrySet().stream()
                    .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                    .sum();

            giveawayResult.put(GIVEAWAY_EVENT_TITLE, totalEventPrice);
        }

        return giveawayResult;
    }
}
