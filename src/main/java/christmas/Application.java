package christmas;

import christmas.controller.display.MessageController;
import christmas.view.display.MessageView;

public class Application {
    public static void main(String[] args) {
        ChristmasPromotionApplication christmasPromotionApplication = new ChristmasPromotionApplication(
                new MessageController(new MessageView()));
        christmasPromotionApplication.start();
    }
}
