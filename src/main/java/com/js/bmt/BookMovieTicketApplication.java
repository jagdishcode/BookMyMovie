package com.js.bmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMovieTicketApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookMovieTicketApplication.class, args);
	}

}
