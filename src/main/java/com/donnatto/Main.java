package com.donnatto;


import com.donnatto.model.Account;
import com.donnatto.model.AccountType;
import com.donnatto.model.Bank;

public class Main {


    public static void main(String[] args) {

        Account account = new Account("898013162578237");

        Validator validator = new Validator();
        String cci = validator.calculateCCI(Bank.INTERBANK, AccountType.AHORROS, account);

    }
}
