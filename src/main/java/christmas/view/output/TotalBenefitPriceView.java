package christmas.view.output;

import static christmas.view.output.constant.PrintFormat.amountFormat;

import christmas.view.output.constant.ResultTitle;

public class TotalBenefitPriceView extends ResultView {
    private final int amount;

    public TotalBenefitPriceView(int amount) {
        this.amount = amount;
    }

    @Override
    void printTitle() {
        System.out.println(ResultTitle.TOTAL_BENEFIT_PRICE.getMessage());
    }

    @Override
    void printResult() {
        System.out.println(amountFormat.format(amount));
    }
}
