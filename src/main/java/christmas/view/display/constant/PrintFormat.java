package christmas.view.display.constant;

import java.text.DecimalFormat;

public class PrintFormat {
    public static final String ORDER_DETAILS_FORMAT = "%s %d개";
    public static final String PRICE_FORM = "###,###원";
    public static final String BENEFITS_DETAILS_FORMAT = "%s: %s";
    public static final DecimalFormat PRICE_FORMAT = new DecimalFormat(PRICE_FORM);
}
