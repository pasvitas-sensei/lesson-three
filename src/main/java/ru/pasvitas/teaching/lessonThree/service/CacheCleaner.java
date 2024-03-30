package ru.pasvitas.teaching.lessonThree.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

@Component
public class CacheCleaner {


    @CacheEvict(cacheNames = "items")
    public void cleanCache() {

    }
}
