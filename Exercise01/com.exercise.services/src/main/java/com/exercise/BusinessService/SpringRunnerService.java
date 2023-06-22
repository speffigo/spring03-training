package com.exercise.BusinessService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.exercise.DataServices.BusinessDataService;

@Configuration
@ComponentScan("com.exercise.DataServices")
public class SpringRunnerService {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(SpringRunnerService.class)) {

			System.out.println(context.getBean(BusinessDataService.class).findmax());
		}
	}
}
