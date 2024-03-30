package ru.pasvitas.teaching.lessonThree.exceptions;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@Component
public class OrderExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleItemNotFoundException(ItemNotFoundException e) {
        return ResponseEntity.badRequest().body(
                new ErrorResponse(
                        400L,
                        "Нет товара с таким ид: " + e.getId()
                )
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        String uuid = UUID.randomUUID().toString();
        log.error("Exception with uuid {}: {}", uuid, e.getMessage(), e);
        return ResponseEntity.badRequest().body(
                new ErrorResponse(
                        500L,
                        "Что-то пошло не так, уже исправляем. Пожалуйста, обратитесь с номером ошибки: " + uuid
                )
        );
    }

}
