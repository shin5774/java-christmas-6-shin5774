package christmas.domain;

import static christmas.domain.constant.Constant.GIVEAWAY_EVENT_TITLE;

import java.util.List;

public class Benefits {
    private final List<Benefit> benefits;

    private Benefits(List<Benefit> benefits) {
        this.benefits = benefits;
    }

    public static Benefits from(List<Benefit> benefits) {
        return new Benefits(benefits);
    }

    public int getTotalBenefitAmount() {
        return benefits.stream()
                .mapToInt(Benefit::getPrice)
                .sum();
    }

    public List<Benefit> getBenefitDetails() {
        return benefits;
    }

    public boolean hasGiveawayEvent() {
        return benefits.stream()
                .anyMatch(benefit -> benefit.isEqualTitle(GIVEAWAY_EVENT_TITLE));
    }
}
