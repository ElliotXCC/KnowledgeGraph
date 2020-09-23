package com.radar.knowledgegraph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class KnowledgegraphApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowledgegraphApplication.class, args);
	}

}
