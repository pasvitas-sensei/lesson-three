package ru.pasvitas.teaching.lessonThree.controller;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pasvitas.teaching.lessonThree.api.VisitorClient;
import ru.pasvitas.teaching.lessonThree.api.responses.Visitor;
import ru.pasvitas.teaching.lessonThree.model.Item;
import ru.pasvitas.teaching.lessonThree.service.ItemService;

@RequiredArgsConstructor
@RequestMapping("/items")
@RestController
@Slf4j
public class ItemController {

    private final VisitorClient visitorClient;

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> makeNewItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.create(item));
    }

    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
        try {
            visitorClient.registerVisitor(new Visitor(
                    null,
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    0,
                    null,
                    null
            ));
        }
        catch (Exception e) {
            log.error("Cann't get visitor service: {}", e.getMessage(), e);
        }
        return ResponseEntity.ok(itemService.getAllItems());
    }

}
