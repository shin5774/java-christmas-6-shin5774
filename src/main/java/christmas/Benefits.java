package christmas;

import java.util.Map;

public class Benefits {
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

    public int getActualDiscountAmount(Orders orders) {
        int totalBenefitAmount = getTotalBenefitAmount();

        if (orders.haveGiveawayMenu() && benefits.containsKey("증정 이벤트")) {
            return totalBenefitAmount;
        }
        return totalBenefitAmount - benefits.getOrDefault("증정 이벤트", 0);
    }
}
