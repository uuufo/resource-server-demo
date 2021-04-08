package dev.jlarsen.resourceserverdemo;

import dev.jlarsen.resourceserverdemo.models.Transaction;
import dev.jlarsen.resourceserverdemo.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@SpringBootApplication
public class ResourceServerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServerDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadInitialData(TransactionRepository transactionRepository) {
		return (args) -> {

			transactionRepository.save(new Transaction("Costco", "ACH",
					BigDecimal.valueOf(3.45), LocalDate.of(2019, 3, 21)));
			transactionRepository.save(new Transaction("Capital One", "Online",
					BigDecimal.valueOf(145.23), LocalDate.of(2019, 3, 22)));
			transactionRepository.save(new Transaction("Gas Station", "Withdrawal",
					BigDecimal.valueOf(53.60), LocalDate.of(2019, 3, 23)));
			transactionRepository.save(new Transaction("SCE", "Online",
					BigDecimal.valueOf(73.87), LocalDate.of(2019, 3, 23)));
			transactionRepository.save(new Transaction("Taco Bell", "Withdrawal",
					BigDecimal.valueOf(14.09), LocalDate.of(2019, 3, 24)));
		};
	}
}
