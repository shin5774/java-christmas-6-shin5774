package christmas.view.request;

import static camp.nextstep.edu.missionutils.Console.readLine;

import christmas.dto.OrdersDTO;
import christmas.util.Mapper;

public class RequestOrdersView extends RequestView<OrdersDTO> {
    private static final String INFORMATION_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    @Override
    void displayInformationMessage() {
        System.out.println(INFORMATION_MESSAGE);
    }

    @Override
    OrdersDTO request() {
        return Mapper.toOrdersDTO(readLine());
    }
}
