package christmas;

import java.util.HashMap;
import java.util.Map;

public class GiveawayEvent {
    private static final String GIVEAWAY_EVENT_TITLE = "증정 이벤트";
    private static final Map<Menu, Integer> GIVEAWAY_EVENT_ITEMS = Map.of(Menu.CHAMPAGNE, 1);
    private static final int MINIMUM_GIVEAWAY_EVENT_AMOUNT = 120000;

    public static boolean canApplyGiveawayEvent(int totalOrderAmount) {
        return totalOrderAmount >= MINIMUM_GIVEAWAY_EVENT_AMOUNT;
    }

    public static Map<String, Integer> getGiveawayEventResult(int totalOrderAmount) {
        Map<String, Integer> giveawayResult = new HashMap<>();

        if (canApplyGiveawayEvent(totalOrderAmount)) {
            int totalEventPrice = -GIVEAWAY_EVENT_ITEMS.entrySet().stream()
                    .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                    .sum();

            giveawayResult.put(GIVEAWAY_EVENT_TITLE, totalEventPrice);
        }

        return giveawayResult;
    }

    public static Map<String, Integer> getGiveawayEventItems(int totalOrderAmount) {
        Map<String, Integer> giveawayItem = new HashMap<>();

        if (canApplyGiveawayEvent(totalOrderAmount)) {
            GIVEAWAY_EVENT_ITEMS.forEach((key, value) -> giveawayItem.put(key.getName(), value));
        }

        return giveawayItem;
    }
}
