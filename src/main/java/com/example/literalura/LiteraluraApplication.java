package com.example.literalura;

import com.example.literalura.service.ConsumoApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		ConsumoApi consumoApi = new ConsumoApi();
		var consumindoApi = consumoApi.obterDados("https://gutendex.com/books/1/");
		System.out.println(consumindoApi);

	}
}
