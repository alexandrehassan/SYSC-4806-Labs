package com.example.labs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new BuddyInfo("Bauer", "4"));
            repository.save(new BuddyInfo("Chloe", "O'Brian"));
            repository.save(new BuddyInfo("Bauer", "4"));
            repository.save(new BuddyInfo("David", "Palmer"));
            repository.save(new BuddyInfo("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddyInfo : repository.findAll()) {
                log.info(buddyInfo.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            BuddyInfo buddyInfo = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------\n\n");
            log.info(buddyInfo.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}