package christmas.controller.request;

import christmas.domain.Orders;
import christmas.dto.OrdersDTO;
import christmas.util.Mapper;
import christmas.view.InputView;

public class RequestOrdersController extends RequestController<Orders> {
    private InputView inputView = new InputView();

    @Override
    Orders active() {
        OrdersDTO ordersDTO = inputView.requestOrders();
        return Mapper.toOrders(ordersDTO);
    }
}
