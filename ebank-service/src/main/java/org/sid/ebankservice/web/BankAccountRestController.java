package org.sid.ebankservice.web;

import org.sid.ebankservice.clients.CustomerRestClient;
import org.sid.ebankservice.entities.BankAccount;
import org.sid.ebankservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BankAccountRestController {

    private final BankAccountRepository bankAccountRepository;
    private final CustomerRestClient customerRestClient;

    public BankAccountRestController(BankAccountRepository bankAccountRepository,
                                     CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accounts() {
        List<BankAccount> accounts = bankAccountRepository.findAll();
        accounts.forEach(account ->
                account.setCustomer(customerRestClient.findCustomerById(account.getCustomerId())));
        return accounts;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount accountById(@PathVariable String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account " + id + " not found"));
        bankAccount.setCustomer(customerRestClient.findCustomerById(bankAccount.getCustomerId()));
        return bankAccount;
    }

    @PostMapping("/accounts")
    public BankAccount saveAccount(@RequestBody BankAccount bankAccount) {
        if (bankAccount.getAccountId() == null) {
            bankAccount.setAccountId(UUID.randomUUID().toString());
        }
        if (bankAccount.getCreatedAt() == null) {
            bankAccount.setCreatedAt(LocalDate.now());
        }
        return bankAccountRepository.save(bankAccount);
    }
}