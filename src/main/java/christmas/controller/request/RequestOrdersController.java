package christmas.controller.request;

import christmas.domain.Orders;
import christmas.dto.OrdersDTO;
import christmas.util.Mapper;
import christmas.view.request.RequestOrdersView;

public class RequestOrdersController extends RequestController<Orders> {
    private RequestOrdersView requestView = new RequestOrdersView();

    @Override
    Orders active() {
        OrdersDTO ordersDTO = requestView.process();
        return Mapper.toOrders(ordersDTO);
    }
}
