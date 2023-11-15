package christmas.domain;

import static christmas.domain.constant.Constant.GIVEAWAY_EVENT_TITLE;

import java.util.Map;

public class Benefits {
    private static final int MINIMUM_GIVEAWAY_EVENT_PRICE = 0;
    private final Map<String, Integer> benefits;

    private Benefits(Map<String, Integer> benefits) {
        this.benefits = benefits;
    }

    public static Benefits from(Map<String, Integer> benefits) {
        return new Benefits(benefits);
    }

    public int getTotalBenefitAmount() {
        return benefits.keySet().stream()
                .mapToInt(benefits::get)
                .sum();
    }

    public Map<String, Integer> getBenefitDetails() {
        return benefits;
    }

    public boolean hasGiveawayEvent() {
        return benefits.containsKey(GIVEAWAY_EVENT_TITLE);
    }

    public int getGiveawayEventPrice() {
        return benefits.getOrDefault(GIVEAWAY_EVENT_TITLE, MINIMUM_GIVEAWAY_EVENT_PRICE);
    }
}
