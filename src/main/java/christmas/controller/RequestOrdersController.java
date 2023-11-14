package christmas.controller;

import christmas.InputView;
import christmas.Mapper;
import christmas.Orders;
import christmas.dto.OrdersDTO;

public class RequestOrdersController extends RequestController<Orders> {
    private InputView inputView = new InputView();

    @Override
    Orders active() {
        OrdersDTO ordersDTO = inputView.requestOrders();
        return Mapper.toOrders(ordersDTO);
    }
}
