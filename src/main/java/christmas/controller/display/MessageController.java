package christmas.controller.display;

import christmas.view.display.MessageView;

public class MessageController {
    private final MessageView messageView;

    public MessageController(MessageView messageView) {
        this.messageView = messageView;
    }

    public void displayPlannerStartMessage() {
        messageView.printPlannerStartMessage();
    }

    public void displayResultStartMessage() {
        messageView.printResultStartMessage();
    }
}
