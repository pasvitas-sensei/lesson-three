package ru.pasvitas.teaching.lessonThree.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.pasvitas.teaching.lessonThree.controller.requests.OrderRequest;
import ru.pasvitas.teaching.lessonThree.exceptions.ItemNotFoundException;
import ru.pasvitas.teaching.lessonThree.model.Item;
import ru.pasvitas.teaching.lessonThree.model.Order;
import ru.pasvitas.teaching.lessonThree.model.User;
import ru.pasvitas.teaching.lessonThree.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ItemService itemService;

    @Override
    public Order placeNewOrder(OrderRequest order) throws ItemNotFoundException {
        Optional<Item> item = itemService.getItemById(order.getItemId());
        if (item.isPresent()) {
            return orderRepository.save(
                    new Order(
                            null,
                            item.get(),
                            (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
                            order.getAddress(),
                            new Date()
                    )
            );
        }
        else {
            throw new ItemNotFoundException(order.getItemId());
        }
    }

    @Override
    public Page<Order> getAllOrders(int page, boolean sortByDate) {
        int size = 2;
        return orderRepository.findAll(PageRequest.of(page, size, Sort.by("orderDate")));
    }

    @Override
    public List<Order> getOrdersByItem(Long id) throws ItemNotFoundException {
        Optional<Item> item = itemService.getItemById(id);
        if (item.isPresent()) {
            return orderRepository.findAllByItem(item.get());
        }
        else {
            throw new ItemNotFoundException(id);
        }
    }
}
