package christmas.domain;

import static christmas.domain.constant.Constant.GIVEAWAY_EVENT_ITEMS;
import static christmas.domain.constant.Constant.GIVEAWAY_EVENT_TITLE;

import java.util.HashMap;
import java.util.Map;

public class GiveawayEvent {
    private static final int MINIMUM_GIVEAWAY_EVENT_AMOUNT = 120000;

    public static Map<String, Integer> getGiveawayEventPriceResult(int totalOrderPrice) {
        Map<String, Integer> giveawayResult = new HashMap<>();

        if (canApplyGiveawayEvent(totalOrderPrice)) {
            int totalEventPrice = -GIVEAWAY_EVENT_ITEMS.entrySet().stream()
                    .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                    .sum();

            giveawayResult.put(GIVEAWAY_EVENT_TITLE, totalEventPrice);
        }

        return giveawayResult;
    }

    public static Map<String, Integer> getGiveawayEventMenuResult(int totalOrderPrice) {
        Map<String, Integer> giveawayItem = new HashMap<>();

        if (canApplyGiveawayEvent(totalOrderPrice)) {
            GIVEAWAY_EVENT_ITEMS.forEach((key, value) -> giveawayItem.put(key.getName(), value));
        }

        return giveawayItem;
    }

    private static boolean canApplyGiveawayEvent(int totalOrderPrice) {
        return totalOrderPrice >= MINIMUM_GIVEAWAY_EVENT_AMOUNT;
    }

}
