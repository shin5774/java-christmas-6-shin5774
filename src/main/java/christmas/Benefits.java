package christmas;

import java.util.Map;

public class Benefits {
    private static final String EXCEPT_EVENT = "증정 이벤트";
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

    public int getExpectedPayAmount(int chargeAmount) {
        int totalBenefitAmount = getTotalBenefitAmount();

        if (benefits.containsKey(EXCEPT_EVENT)) {
            totalBenefitAmount -= benefits.get(EXCEPT_EVENT);
        }

        return setNegativeAmountToZero(chargeAmount - totalBenefitAmount);
    }

    private int setNegativeAmountToZero(int paymentAmount) {
        return Math.max(paymentAmount, 0);
    }
}
