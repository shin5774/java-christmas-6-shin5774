package christmas.view.display;

import static christmas.view.display.constant.PrintFormat.amountFormat;

import christmas.view.display.constant.ResultTitle;

public class AfterOrderPriceView extends ResultView {
    private final int amount;

    public AfterOrderPriceView(int amount) {
        this.amount = amount;
    }

    @Override
    void printTitle() {
        System.out.println(ResultTitle.AFTER_ORDER_PRICE.getMessage());
    }

    @Override
    void printResult() {
        System.out.println(amountFormat.format(amount));
    }
}
