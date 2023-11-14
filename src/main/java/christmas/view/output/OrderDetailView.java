package christmas.view.output;

import static christmas.view.output.constant.PrintFormat.ORDER_DETAILS_FORMAT;

import christmas.view.output.constant.ResultTitle;
import java.util.Map;

public class OrderDetailView extends ResultView {
    private final Map<String, Integer> orderDetails;

    public OrderDetailView(Map<String, Integer> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    void printTitle() {
        System.out.println(ResultTitle.ORDER_MENU.getMessage());
    }

    @Override
    void printResult() {
        orderDetails.keySet()
                .forEach(menu -> System.out.println(String.format(ORDER_DETAILS_FORMAT, menu, orderDetails.get(menu))));
    }
}
