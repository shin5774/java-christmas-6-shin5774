package christmas;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NONE("없음", 0);

    private final String name;
    private final int aquisitionCondition;

    Badge(String name, int aquisitionCondition) {
        this.name = name;
        this.aquisitionCondition = aquisitionCondition;
    }

    public static Badge findBadge(int benefitAmount) {
        return Arrays.stream(Badge.values())
                .filter(badge -> badge.canGetBadge(benefitAmount))
                .findFirst()
                .orElse(NONE);
    }

    private boolean canGetBadge(int benefitAmount) {
        return benefitAmount >= aquisitionCondition;
    }

    public String getName() {
        return name;
    }
}
