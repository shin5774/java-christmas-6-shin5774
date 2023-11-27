package christmas.view.display.constant;

public enum ResultTitle {
    ORDER_MENU("주문 메뉴"),
    BEFORE_ORDER_PRICE("할인 전 총주문 금액"),
    GIVEAWAY_MENU("증정 메뉴"),
    BENEFIT_DETAILS("혜택 내역"),
    TOTAL_BENEFIT_PRICE("총혜택 금액"),
    AFTER_ORDER_PRICE("할인 후 예상 결제 금액"),
    BADGE("12월 이벤트 배지");

    private static final String PREFIX = "<";
    private static final String SUFFIX = ">";

    private final String message;

    ResultTitle(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message + SUFFIX;
    }
}
