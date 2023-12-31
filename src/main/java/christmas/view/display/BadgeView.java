package christmas.view.display;

import christmas.view.display.constant.ResultTitle;

public class BadgeView extends ResultView {
    private final String badgeTitle;

    public BadgeView(String badgeTitle) {
        this.badgeTitle = badgeTitle;
    }

    @Override
    void printTitle() {
        System.out.println(ResultTitle.BADGE.getMessage());
    }

    @Override
    void printResult() {
        System.out.println(badgeTitle);
    }
}
