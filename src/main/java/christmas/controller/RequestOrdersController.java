package christmas.controller;

import christmas.InputView;
import christmas.Menu;
import christmas.MenuAndAmount;
import christmas.MenusValidator;
import christmas.Orders;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RequestOrdersController extends RequestController<Orders> {
    private InputView inputView = new InputView();

    @Override
    Orders active() {
        List<MenuAndAmount> requestOrders = inputView.requestOrders();
        MenusValidator.validate(requestOrders);

        Map<Menu, Integer> inputOrders = new EnumMap<>(Menu.class);
        requestOrders.forEach(
                order -> inputOrders.put(Menu.findMenu(order.menu()), Integer.parseInt(order.amount())));
        return Orders.of(inputOrders);
    }
}
