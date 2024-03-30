package ru.pasvitas.teaching.lessonThree.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ItemNotFoundException extends Exception {

    private final Long id;
}
