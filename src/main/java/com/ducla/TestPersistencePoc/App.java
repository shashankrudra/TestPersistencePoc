package com.ducla.TestPersistencePoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.deloitte.ucl.TestPersistencePoc" })
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App.class, args);
		AppRunner ar = (AppRunner) ctx.getBean("appRunner");
		ar.testService();
	}
}