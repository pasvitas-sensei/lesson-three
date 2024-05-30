package ru.pasvitas.teaching.lessonThree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAspectJAutoProxy
@EnableFeignClients
@EnableScheduling
@EnableCaching
@EnableTransactionManagement
@SpringBootApplication
public class LessonThreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LessonThreeApplication.class, args);
	}

}
