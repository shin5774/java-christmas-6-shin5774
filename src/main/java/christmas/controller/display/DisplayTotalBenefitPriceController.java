package christmas.controller.display;

import christmas.domain.Benefits;
import christmas.view.display.TotalBenefitPriceView;

public class DisplayTotalBenefitPriceController implements DisplayController {
    private final Benefits benefits;

    public DisplayTotalBenefitPriceController(Benefits benefits) {
        this.benefits = benefits;
    }

    @Override
    public void proceed() {
        new TotalBenefitPriceView(benefits.getTotalBenefitAmount()).proceed();
    }
}
