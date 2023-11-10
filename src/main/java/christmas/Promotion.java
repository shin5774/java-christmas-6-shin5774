package christmas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public enum Promotion {
    CHRISTMAS_D_DAY(day -> 1000 + (day - 1) * 100, day -> day <= 25),
    WEEKDAY(always -> 2023, day -> !(day % 7 == 1 || day % 7 == 2)),
    WEEKEND(always -> 2023, day -> day % 7 == 1 || day % 7 == 2),
    SPECIAL(always -> 1000, day -> List.of(3, 10, 17, 24, 25, 31).contains(day));


    private final UnaryOperator<Integer> discountAmount;
    private final Predicate<Integer> applicable;

    Promotion(UnaryOperator<Integer> discountAmount, Predicate<Integer> applicable) {
        this.discountAmount = discountAmount;
        this.applicable = applicable;
    }

    public static List<Promotion> findPromotions(int day) {
        return Arrays.stream(Promotion.values())
                .filter(promotion -> promotion.applicable.test(day))
                .toList();
    }
}
