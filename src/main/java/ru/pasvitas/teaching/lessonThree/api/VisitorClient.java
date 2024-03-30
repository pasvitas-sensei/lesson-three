package ru.pasvitas.teaching.lessonThree.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.pasvitas.teaching.lessonThree.api.responses.Visitor;

@FeignClient(name = "visitor", url = "${visitor.url}")
public interface VisitorClient {

    @PostMapping("/visitors")
    ResponseEntity<Visitor> registerVisitor(@RequestBody Visitor visitor);
}
