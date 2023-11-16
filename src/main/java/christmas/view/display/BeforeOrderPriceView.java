package christmas.view.display;

import static christmas.view.display.constant.PrintFormat.PRICE_FORMAT;

import christmas.view.display.constant.ResultTitle;

public class BeforeOrderPriceView extends ResultView {
    private final int price;

    public BeforeOrderPriceView(int price) {
        this.price = price;
    }

    @Override
    void printTitle() {
        System.out.println(ResultTitle.BEFORE_ORDER_PRICE.getMessage());
    }

    @Override
    void printResult() {
        System.out.println(PRICE_FORMAT.format(price));
    }
}
