package christmas.controller.request;

import christmas.domain.Orders;
import christmas.dto.OrdersDTO;
import christmas.util.Mapper;
import christmas.view.request.RequestView;

public class RequestOrdersController extends RequestController<Orders> {
    private final RequestView<OrdersDTO> requestView;

    public RequestOrdersController(RequestView<OrdersDTO> requestView) {
        this.requestView = requestView;
    }

    @Override
    Orders request() {
        OrdersDTO ordersDTO = requestView.process();
        return Mapper.toOrders(ordersDTO);
    }
}
