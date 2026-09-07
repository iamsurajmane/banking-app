package com.example.demo.service;

import com.example.demo.dto.AccountDto;


public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id,double amount);

}
