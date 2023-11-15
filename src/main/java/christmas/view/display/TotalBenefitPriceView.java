package christmas.view.display;

import static christmas.view.display.constant.PrintFormat.amountFormat;

import christmas.view.display.constant.ResultTitle;

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
