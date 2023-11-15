package christmas.view.display.constant;

import java.text.DecimalFormat;

public class PrintFormat {
    public static final String ORDER_DETAILS_FORMAT = "%s %d개";
    public static final String PRICE_FORMAT = "###,###원";
    public static final String BENEFITS_DETAILS_FORMAT = "%s: %s";
    public static final DecimalFormat amountFormat = new DecimalFormat(PRICE_FORMAT);
}
