package christmas.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Badge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000);

    private final String name;
    private final int acquisitionCondition;

    Badge(String name, int acquisitionCondition) {
        this.name = name;
        this.acquisitionCondition = acquisitionCondition;
    }

    public static Optional<Badge> findBadge(int benefitAmount) {
        return Arrays.stream(Badge.values())
                .filter(badge -> badge.canGetBadge(benefitAmount))
                .findFirst();
    }

    private boolean canGetBadge(int benefitAmount) {
        return benefitAmount >= acquisitionCondition;
    }

    public String getName() {
        return name;
    }
}
