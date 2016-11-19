package edu.mum.ea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Controller
//@EnableAutoConfiguration
public class BankingApplication {
	
	// @RequestMapping("/")
	// @ResponseBody
	// String home() {
	// return "Hello World!";
	// }

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}
}
