package christmas;

import christmas.view.display.OutputView;

public class Application {
    public static void main(String[] args) {
        ChristmasPromotionApplication christmasPromotionApplication = new ChristmasPromotionApplication(
                new OutputView());
        christmasPromotionApplication.start();
    }
}
