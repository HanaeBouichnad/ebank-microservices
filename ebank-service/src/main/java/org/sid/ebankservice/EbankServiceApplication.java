package org.sid.ebankservice;

import org.sid.ebankservice.entities.BankAccount;
import org.sid.ebankservice.enums.AccountType;
import org.sid.ebankservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository) {
        return args -> {
            for (long customerId = 1; customerId <= 3; customerId++) {
                BankAccount currentAccount = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .balance(Math.round(Math.random() * 50000))
                        .createdAt(LocalDate.now())
                        .currency("MAD")
                        .type(AccountType.CURRENT_ACCOUNT)
                        .customerId(customerId)
                        .build();

                BankAccount savingAccount = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .balance(Math.round(Math.random() * 100000))
                        .createdAt(LocalDate.now())
                        .currency("MAD")
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerId(customerId)
                        .build();

                bankAccountRepository.save(currentAccount);
                bankAccountRepository.save(savingAccount);
            }
            bankAccountRepository.findAll().forEach(System.out::println);
        };
    }
}