package christmas.view.output;

import static christmas.view.output.constant.PrintFormat.BENEFITS_DETAILS_FORMAT;
import static christmas.view.output.constant.PrintFormat.amountFormat;

import christmas.view.output.constant.ResultTitle;
import java.util.Map;
import java.util.Map.Entry;

public class BenefitDetailsView extends ResultView {
    private static final String NONE_EXIST = "없음";
    private final Map<String, Integer> benefitsDetails;

    public BenefitDetailsView(Map<String, Integer> benefitsDetails) {
        this.benefitsDetails = benefitsDetails;
    }

    @Override
    void printTitle() {
        System.out.println(ResultTitle.BENEFIT_DETAILS.getMessage());
    }

    @Override
    void printResult() {
        if (benefitsDetails.isEmpty()) {
            System.out.println(NONE_EXIST);
            return;
        }

        benefitsDetails.entrySet().forEach(this::printBenefit);
    }

    private void printBenefit(Entry<String, Integer> benefit) {
        System.out.println(String.format(BENEFITS_DETAILS_FORMAT, benefit.getKey(),
                amountFormat.format(benefit.getValue())));
    }
}
