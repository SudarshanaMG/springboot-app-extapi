package com.ust.Springboot_docker_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootDockerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerAppApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(5000); // 5 seconds
		factory.setReadTimeout(5000);
		return new RestTemplate(factory);

	}
}
