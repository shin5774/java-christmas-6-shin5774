package christmas.view.display;

import static christmas.view.display.constant.PrintFormat.PRICE_FORMAT;

import christmas.view.display.constant.ResultTitle;

public class TotalBenefitPriceView extends ResultView {
    private final int price;

    public TotalBenefitPriceView(int price) {
        this.price = price;
    }

    @Override
    void printTitle() {
        System.out.println(ResultTitle.TOTAL_BENEFIT_PRICE.getMessage());
    }

    @Override
    void printResult() {
        System.out.println(PRICE_FORMAT.format(price));
    }
}
