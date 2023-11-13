package christmas;

import java.util.Map;

public class OutputView {
    private static final String ORDER_DETAILS_FORMAT = "%s %d개";

    public void printOrderDetails(Map<String, Integer> orderDetails) {
        System.out.println("<주문 메뉴>");
        orderDetails.keySet()
                .forEach(menu -> System.out.println(String.format(ORDER_DETAILS_FORMAT, menu, orderDetails.get(menu))));
        System.out.println();
    }


}
