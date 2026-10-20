package org.sid.ebankservice.web;

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

    public BankAccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount accountById(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account " + id + " not found"));
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