package christmas.controller.display;

import christmas.domain.Badge;
import christmas.domain.Benefits;
import christmas.view.display.BadgeView;
import java.util.Optional;

public class DisplayBadgeController implements DisplayController {
    private static final String EMPTY_BADGE_TITLE = "없음";
    private final Benefits benefits;

    public DisplayBadgeController(Benefits benefits) {
        this.benefits = benefits;
    }

    @Override
    public void proceed() {
        int totalBenefitsAmount = benefits.getTotalBenefitAmount();
        Optional<Badge> badge = Badge.findBadge(-totalBenefitsAmount);
        new BadgeView(getBadgeTitle(badge)).proceed();
    }

    private String getBadgeTitle(Optional<Badge> badge) {
        if (badge.isPresent()) {
            return badge.get().getName();
        }
        return EMPTY_BADGE_TITLE;
    }
}
