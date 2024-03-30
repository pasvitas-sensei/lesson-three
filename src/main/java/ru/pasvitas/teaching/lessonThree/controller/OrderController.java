package ru.pasvitas.teaching.lessonThree.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.pasvitas.teaching.lessonThree.controller.requests.OrderRequest;
import ru.pasvitas.teaching.lessonThree.exceptions.ItemNotFoundException;
import ru.pasvitas.teaching.lessonThree.model.Order;
import ru.pasvitas.teaching.lessonThree.service.OrderService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest orderRequest) throws ItemNotFoundException {
        return ResponseEntity.ok(orderService.placeNewOrder(orderRequest));
    }

    @GetMapping
    public ResponseEntity<Page<Order>> getAllOrders(
            @RequestParam int page,
            @RequestParam boolean sortByDate
    ) {
        return ResponseEntity.ok(orderService.getAllOrders(page, sortByDate));
    }

    @GetMapping("/findById")
    public ResponseEntity<List<Order>> getOrderByItemId(@RequestParam("id") Long id) throws ItemNotFoundException {
        return ResponseEntity.ok(orderService.getOrdersByItem(id));
    }
}
