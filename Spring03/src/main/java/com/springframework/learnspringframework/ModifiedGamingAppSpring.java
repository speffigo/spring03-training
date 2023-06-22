package com.springframework.learnspringframework;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Lazy
class Business {

	Dependency1 dependency1;

	Dependency2 dependency2;

	public Business(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor-Depen");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;

	}

	@PostConstruct
	public void initialise() {
		dependency1.run();
	}
}

@Component
class Dependency1 {

	public void run() {
		System.out.println("Showing how PostConstruct works");

	}
}

@Component
@Scope(value = "prototype")
class Dependency2 {

	@PreDestroy
	public void drop() {
		System.out.println("This is the last time u r seeing me");
	}

}

@Configuration
@ComponentScan("com.springframework.learnspringframework")
public class ModifiedGamingAppSpring {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(ModifiedGamingAppSpring.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

			//System.out.println(context.getBean(Business.class));

			//getting bean of a class whose scope is prototype.
			System.out.println(context.getBean(Dependency2.class));
			System.out.println(context.getBean(Dependency2.class));

			//getting bean of a class whose scope is singleton
			System.out.println(context.getBean(Dependency1.class));
			System.out.println(context.getBean(Dependency1.class));

		}

	}

}
