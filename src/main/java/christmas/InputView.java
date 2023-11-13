package christmas;

import static camp.nextstep.edu.missionutils.Console.readLine;

import christmas.dto.VisitedDateDTO;
import java.util.List;

public class InputView {
    public VisitedDateDTO requestVisitedDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        return new VisitedDateDTO(readLine());
    }

    public List<MenuAndAmount> requestOrders() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        return Parser.parseMenus(readLine()).stream()
                .map(Parser::parseMenuAndAmount)
                .toList();
    }
}
