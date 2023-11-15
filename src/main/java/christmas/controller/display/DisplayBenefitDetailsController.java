package christmas.controller.display;

import christmas.domain.Benefits;
import christmas.view.display.BenefitDetailsView;

public class DisplayBenefitDetailsController implements DisplayController {
    private final Benefits benefits;

    public DisplayBenefitDetailsController(Benefits benefits) {
        this.benefits = benefits;
    }

    @Override
    public void proceed() {
        new BenefitDetailsView(benefits.getBenefitDetails()).proceed();
    }
}
