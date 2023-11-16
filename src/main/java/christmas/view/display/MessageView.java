package christmas.view.display;

public class MessageView {
    public static final String PLANNER_START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    public static final String RESULT_START_MESSAGE = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!" + System.lineSeparator();

    public void printPlannerStartMessage() {
        System.out.println(PLANNER_START_MESSAGE);
    }

    public void printResultStartMessage() {
        System.out.println(RESULT_START_MESSAGE);
    }
}
