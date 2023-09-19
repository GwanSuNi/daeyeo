package com.daeyeo.helloDaeyeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloDaeyeoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloDaeyeoApplication.class, args);
		Hello hello = new Hello();
		hello.setData("hello");
		String data = hello.getData();
		System.out.println(data);

	}

}
