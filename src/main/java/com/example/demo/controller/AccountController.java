package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

//    add account
    @PostMapping("createAC")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

//    get account details
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
//        AccountDto accountDto = accountService.getAccountById(id);
        return new ResponseEntity<>(accountService.getAccountById(id),HttpStatus.OK);
    }

//    deposit api
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                                  @RequestBody Map<String,Double> request){
        double amount = request.get("Amount");

        AccountDto accountDto = accountService.deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }

//Withdraw api

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String,Double> request
                                               ){
        double amount = request.get("Amount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }

//    get all accounts
    @GetMapping("getAll")
    public List<AccountDto> getAllAccounts(){
        List<AccountDto> allAccounts = accountService.getAllAccounts();
        return allAccounts;
    }

    @DeleteMapping("/{id}/delete")
    public String deleteById(@PathVariable Long id){
        accountService.deleteAC(id);
        return "Account Deleted Succesfully...";
    }
}
