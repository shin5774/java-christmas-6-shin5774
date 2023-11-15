package christmas.controller.display;

import christmas.Badge;
import christmas.Benefits;
import christmas.view.output.BadgeView;

public class DisplayBadgeController implements DisplayController {
    private final Benefits benefits;

    public DisplayBadgeController(Benefits benefits) {
        this.benefits = benefits;
    }

    @Override
    public void process() {
        int totalBenefitsAmount = benefits.getTotalBenefitAmount();
        Badge badge = Badge.findBadge(-totalBenefitsAmount);
        new BadgeView(badge.getName()).process();
    }
}
