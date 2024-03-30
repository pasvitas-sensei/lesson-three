package ru.pasvitas.teaching.lessonThree.service;

import java.util.List;
import org.springframework.data.domain.Page;
import ru.pasvitas.teaching.lessonThree.controller.requests.OrderRequest;
import ru.pasvitas.teaching.lessonThree.exceptions.ItemNotFoundException;
import ru.pasvitas.teaching.lessonThree.model.Order;

public interface OrderService {
    Order placeNewOrder(OrderRequest order) throws ItemNotFoundException;
    Page<Order> getAllOrders(int page, boolean sortByDate);
    List<Order> getOrdersByItem(Long id) throws ItemNotFoundException;
}
