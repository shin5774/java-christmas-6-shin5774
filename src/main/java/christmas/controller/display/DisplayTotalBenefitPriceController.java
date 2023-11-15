package christmas.controller.display;

import christmas.Benefits;
import christmas.view.output.TotalBenefitPriceView;

public class DisplayTotalBenefitPriceController implements DisplayController {
    private final Benefits benefits;

    public DisplayTotalBenefitPriceController(Benefits benefits) {
        this.benefits = benefits;
    }

    @Override
    public void process() {
        new TotalBenefitPriceView(benefits.getTotalBenefitAmount()).process();
    }
}
