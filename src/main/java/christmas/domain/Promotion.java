package christmas.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public enum Promotion {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인", day -> -(1000 + (day - 1) * 100), VisitedDate::isBeforeChristmas, MenuGroup.NONE),
    WEEKDAY("평일 할인", always -> -2023, VisitedDate::isWeekday, MenuGroup.DESSERT),
    WEEKEND("주말 할인", always -> -2023, VisitedDate::isWeekend, MenuGroup.MAIN),
    SPECIAL("특별 할인", always -> -1000, VisitedDate::isSpecialDate, MenuGroup.NONE);

    private static final int MINIMAL_MENU_AMOUNT = 1;

    private final String title;
    private final UnaryOperator<Integer> discountAmount;
    private final Predicate<VisitedDate> applicable;
    private final MenuGroup discountMenuGroup;

    Promotion(String title, UnaryOperator<Integer> discountAmount, Predicate<VisitedDate> applicable,
              MenuGroup discountMenuGroup) {
        this.title = title;
        this.discountAmount = discountAmount;
        this.applicable = applicable;
        this.discountMenuGroup = discountMenuGroup;
    }

    public static List<Promotion> findPromotions(VisitedDate day) {
        return Arrays.stream(Promotion.values())
                .filter(promotion -> promotion.applicable.test(day))
                .toList();
    }

    public int getDiscountPrice(int day, int discountMenuAmount) {
        return discountAmount.apply(day) * getDiscountMenuAmount(discountMenuAmount);
    }

    private int getDiscountMenuAmount(int dicountMenuAmount) {
        if (discountMenuGroup == MenuGroup.NONE) {
            return MINIMAL_MENU_AMOUNT;
        }
        return dicountMenuAmount;
    }

    public String getTitle() {
        return title;
    }

    public MenuGroup getDiscountMenuGroup() {
        return discountMenuGroup;
    }
}
