package christmas;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    private static final String ORDER_DETAILS_FORMAT = "%s %d개";
    private static final String BENEFITS_DETAILS_FORMAT = "%s: %s원";
    private static final DecimalFormat amountFormat = new DecimalFormat("###,###");

    public void printOrderDetails(Map<String, Integer> orderDetails) {
        System.out.println("<주문 메뉴>");
        orderDetails.keySet()
                .forEach(menu -> System.out.println(String.format(ORDER_DETAILS_FORMAT, menu, orderDetails.get(menu))));
        System.out.println();
    }

    private void printAmount(int amount) {
        System.out.println(amountFormat.format(amount) + "원");
    }

    public void printTotalOrderAmount(int amount) {
        System.out.println("<할인 전 총주문 금액>");
        printAmount(amount);
    }

    public void printGiveawayEvent(String giveawayEvent) {
        System.out.println("<증정 메뉴>");
        System.out.println(giveawayEvent);
    }

    public void printBenefits(Map<String, Integer> benefitsDetails) {
        System.out.println("<혜택 내역>");
        if (benefitsDetails.isEmpty()) {
            System.out.println("없음");
            return;
        }
        benefitsDetails.keySet()
                .forEach(benefit -> System.out.println(
                        String.format(BENEFITS_DETAILS_FORMAT, benefit,
                                amountFormat.format(benefitsDetails.get(benefit)))));
    }

    public void printTotalBenefitsAmount(int amount) {
        System.out.println("<총혜택 금액>");
        printAmount(amount);
    }

    public void printExpectedPayAmount(int amount) {
        System.out.println("<할인 후 예상 결제 금액>");
        printAmount(amount);
    }

    public void printBadge(String badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }
}
