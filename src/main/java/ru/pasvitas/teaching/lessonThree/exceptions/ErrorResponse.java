package ru.pasvitas.teaching.lessonThree.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ErrorResponse {

    private final Long codeID;

    private final String message;
}
