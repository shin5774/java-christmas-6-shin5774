package christmas.view.request;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.view.InformationMessage.REQUEST_ORDERS_MESSAGE;

import christmas.dto.OrdersDTO;
import christmas.util.Mapper;

public class RequestOrdersView extends RequestView<OrdersDTO> {

    @Override
    void displayInformationMessage() {
        System.out.println(REQUEST_ORDERS_MESSAGE);
    }

    @Override
    OrdersDTO request() {
        return Mapper.toOrdersDTO(readLine());
    }
}
