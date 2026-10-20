package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customers = List.of(
                    Customer.builder().firstName("Hanae").lastName("Alaoui").email("hanae@gmail.com").build(),
                    Customer.builder().firstName("Yassine").lastName("Bennani").email("yassine@gmail.com").build(),
                    Customer.builder().firstName("Sara").lastName("Idrissi").email("sara@gmail.com").build()
            );
            customerRepository.saveAll(customers);
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}