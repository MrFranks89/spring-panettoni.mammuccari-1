package it.panettoni.mammuccari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import it.panettone.controller.PanettoneController;


@SpringBootApplication
@ComponentScan(basePackages = "it.panettone")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
