package christmas;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public enum Promotion {
    CHRISTMAS_D_DAY(day -> 1000 + (day - 1) * 100, day -> day <= 25, MenuGroup.NONE),
    WEEKDAY(always -> 2023, day -> !(day % 7 == 1 || day % 7 == 2), MenuGroup.DESSERT),
    WEEKEND(always -> 2023, day -> day % 7 == 1 || day % 7 == 2, MenuGroup.MAIN),
    SPECIAL(always -> 1000, day -> List.of(3, 10, 17, 24, 25, 31).contains(day), MenuGroup.NONE);


    private final UnaryOperator<Integer> discountAmount;
    private final Predicate<Integer> applicable;
    private final MenuGroup discountMenuGroup;

    Promotion(UnaryOperator<Integer> discountAmount, Predicate<Integer> applicable,
              MenuGroup discountMenuGroup) {
        this.discountAmount = discountAmount;
        this.applicable = applicable;
        this.discountMenuGroup = discountMenuGroup;
    }

    public static List<Promotion> findPromotions(int day) {
        return Arrays.stream(Promotion.values())
                .filter(promotion -> promotion.applicable.test(day))
                .toList();
    }

    public int getDiscountAmount(int day, Map<Menu, Integer> order) {
        return discountAmount.apply(day) * getDiscountMenuAmount(order);
    }

    private int getDiscountMenuAmount(Map<Menu, Integer> order) {
        if (discountMenuGroup == MenuGroup.NONE) {
            return 1;
        }

        return (int) order.keySet().stream()
                .filter(menu -> MenuGroup.findGroup(menu) == discountMenuGroup)
                .count();
    }
}
