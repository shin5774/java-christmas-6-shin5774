package christmas.view.display;

import static christmas.view.display.constant.PrintFormat.BENEFITS_DETAILS_FORMAT;
import static christmas.view.display.constant.PrintFormat.PRICE_FORMAT;

import christmas.domain.Benefit;
import christmas.view.display.constant.ResultTitle;
import java.util.List;

public class BenefitDetailsView extends ResultView {
    private static final String NONE_EXIST = "없음";
    private final List<Benefit> benefitDetails;

    public BenefitDetailsView(List<Benefit> benefitDetails) {
        this.benefitDetails = benefitDetails;
    }

    @Override
    void printTitle() {
        System.out.println(ResultTitle.BENEFIT_DETAILS.getMessage());
    }

    @Override
    void printResult() {
        if (benefitDetails.isEmpty()) {
            System.out.println(NONE_EXIST);
            return;
        }

        benefitDetails.forEach(this::printBenefit);
    }

    private void printBenefit(Benefit benefit) {
        System.out.println(String.format(BENEFITS_DETAILS_FORMAT, benefit.getTitle(),
                PRICE_FORMAT.format(benefit.getPrice())));
    }
}
