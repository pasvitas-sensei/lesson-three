package ru.pasvitas.teaching.lessonThree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@EnableScheduling
@EnableCaching
@SpringBootApplication
public class LessonThreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LessonThreeApplication.class, args);
	}

}
