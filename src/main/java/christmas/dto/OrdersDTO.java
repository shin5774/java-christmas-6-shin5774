package christmas.dto;

import java.util.List;

public record OrdersDTO(List<MenuAndAmount> requestOrders) {
}
