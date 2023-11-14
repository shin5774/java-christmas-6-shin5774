package christmas.view.output;

import static christmas.view.output.constant.PrintFormat.amountFormat;

import christmas.view.output.constant.ResultTitle;

public class BeforeOrderPriceView extends ResultView {
    private final int amount;

    public BeforeOrderPriceView(int amount) {
        this.amount = amount;
    }

    @Override
    void printTitle() {
        System.out.println(ResultTitle.BEFORE_ORDER_PRICE.getMessage());
    }

    @Override
    void printResult() {
        System.out.println(amountFormat.format(amount));
    }
}
