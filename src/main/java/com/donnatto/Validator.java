package com.donnatto;

import com.donnatto.model.Account;
import com.donnatto.model.AccountType;
import com.donnatto.model.Bank;
import org.apache.commons.lang3.StringUtils;

public class Validator {

    public String calculate(Bank bank, AccountType type, Account account) throws Exception {

        String bankNumber = null;
        String typeNumber = null;
        String officeNumber = null;
        String accountNumber = null;
        String response = null;

        try {
            bankNumber = getBankNumber(bank);
            typeNumber = getTypeNumber(type);
            officeNumber = account.getAccount().substring(0,3);
            accountNumber = account.getAccount().substring(3);

            if (accountNumber.length() < 12) {
                accountNumber = typeNumber + StringUtils.leftPad(accountNumber, 11, "0");
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    private String getTypeNumber(AccountType type) throws Exception {
        switch (type) {
            case CTA_CORRIENTE:
                return "0";
            case AHORROS:
                return "1";
            default:
                throw new Exception("Account type is not valid");
        }
    }

    private String getBankNumber(Bank bank) throws Exception {
        switch (bank) {
            case BCP:
                return  "002";
            case INTERBANK:
                return  "003";
            case SCOTIABANK:
                return  "009";
            default:
                throw new Exception("Bank is not valid");
        }
    }
}
