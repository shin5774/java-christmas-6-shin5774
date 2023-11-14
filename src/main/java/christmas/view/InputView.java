package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.view.InformationMessage.REQUEST_ORDERS_MESSAGE;
import static christmas.view.InformationMessage.REQUEST_VISITED_DATE_MESSAGE;

import christmas.Mapper;
import christmas.dto.OrdersDTO;
import christmas.dto.VisitedDateDTO;

public class InputView {
    public VisitedDateDTO requestVisitedDate() {
        System.out.println(REQUEST_VISITED_DATE_MESSAGE);
        return Mapper.toVisitedDateDTO(readLine());
    }

    public OrdersDTO requestOrders() {
        System.out.println(REQUEST_ORDERS_MESSAGE);
        return Mapper.toOrdersDTO(readLine());
    }
}
