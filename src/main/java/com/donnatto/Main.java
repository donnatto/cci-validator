package com.donnatto;


import com.donnatto.model.Account;
import com.donnatto.model.AccountType;
import com.donnatto.model.Bank;

public class Main {


    public static void main(String[] args) {

        Account account = new Account("19197743512018");

        Validator validator = new Validator();
        String cci = validator.calculateCCI(Bank.BCP, AccountType.AHORROS, account);

    }
}
