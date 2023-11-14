package christmas;

import christmas.dto.OrdersDTO;
import christmas.dto.VisitedDateDTO;
import christmas.exception.VisitedDateException;
import java.util.EnumMap;
import java.util.Map;

public class Mapper {
    public static VisitedDateDTO toVisitedDateDTO(String requestDate) {
        if (Validator.isNotNumber(requestDate)) {
            throw VisitedDateException.from("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }

        return new VisitedDateDTO(requestDate);
    }

    public static VisitedDate toVisitedDate(VisitedDateDTO visitedDateDTO) {
        return VisitedDate.of(toInt(visitedDateDTO.requestDate()));
    }

    private static int toInt(String requestDate) {
        return Integer.parseInt(requestDate);
    }

    public static OrdersDTO toOrdersDTO(String requestOrders) {
        return new OrdersDTO(Parser.parseMenus(requestOrders).stream()
                .map(Parser::parseMenuAndAmount)
                .toList());
    }

    public static Orders toOrders(OrdersDTO ordersDTO) {
        MenusValidator.validate(ordersDTO.requestOrders());

        Map<Menu, Integer> inputOrders = new EnumMap<>(Menu.class);
        ordersDTO.requestOrders().forEach(
                order -> inputOrders.put(Menu.findMenu(order.menu()), Integer.parseInt(order.amount())));

        return Orders.of(inputOrders);
    }
}
