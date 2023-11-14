package christmas.dto;

import christmas.MenuAndAmount;
import java.util.List;

public record OrdersDTO(List<MenuAndAmount> requestOrders) {
}
