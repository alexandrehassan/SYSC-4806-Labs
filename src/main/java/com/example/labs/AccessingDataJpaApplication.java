package com.example.labs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication{
    private static final Logger log=LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository){
        return (args) -> {
            // save a few customers
            repository.save(new BuddyInfo("Jack", "1"));
            repository.save(new BuddyInfo("Jack", "2"));
            repository.save(new BuddyInfo("Jack", "3"));
            repository.save(new BuddyInfo("Jack", "4"));
            repository.save(new BuddyInfo("Jack", "5"));
            repository.save(new BuddyInfo("Paul", "6"));
            repository.save(new BuddyInfo("Paul", "7"));

            // fetch all customers
            log.info("--------------------------------------------");
            log.info("Buddies found with findAll():");
            repository.findAll().forEach(buddyInfo -> log.info(buddyInfo.toString()));
            log.info("");

            // fetch an individual customer by ID
            log.info("--------------------------------------------");
            log.info("Buddy found with findById(1L):");
            BuddyInfo buddyInfo=repository.findById(1L);
            log.info(buddyInfo.toString());
            log.info("");

            // fetch customers by last name
            log.info("--------------------------------------------");
            log.info("Buddy found with findByName('Paul'):");
            repository.findByName("Paul").forEach(paul -> log.info(paul.toString()));
            log.info("");

            log.info("Buddy found with findByPhoneNumber('4'):");
            buddyInfo=repository.findByPhoneNumber("4");
            log.info(buddyInfo.toString());
            log.info("");
        };
    }

//    public static void main(String[] args){
//        SpringApplication.run(AccessingDataJpaApplication.class);
//    }
}
