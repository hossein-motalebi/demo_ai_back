package org.trader.backdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.trader.backdemo")

public class BackDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackDemoApplication.class, args);
	}

}
