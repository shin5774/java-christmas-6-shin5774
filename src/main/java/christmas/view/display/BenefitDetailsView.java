package christmas.view.display;

import static christmas.view.display.constant.PrintFormat.BENEFITS_DETAILS_FORMAT;
import static christmas.view.display.constant.PrintFormat.PRICE_FORMAT;

import christmas.view.display.constant.ResultTitle;
import java.util.Map;
import java.util.Map.Entry;

public class BenefitDetailsView extends ResultView {
    private static final String NONE_EXIST = "없음";
    private final Map<String, Integer> benefitDetails;

    public BenefitDetailsView(Map<String, Integer> benefitDetails) {
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

        benefitDetails.entrySet().forEach(this::printBenefit);
    }

    private void printBenefit(Entry<String, Integer> benefit) {
        System.out.println(String.format(BENEFITS_DETAILS_FORMAT, benefit.getKey(),
                PRICE_FORMAT.format(benefit.getValue())));
    }
}
