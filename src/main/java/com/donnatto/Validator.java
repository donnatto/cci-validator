package com.donnatto;

import com.donnatto.model.Account;
import com.donnatto.model.AccountType;
import com.donnatto.model.Bank;
import org.apache.commons.lang3.StringUtils;

import static com.donnatto.utils.Helpers.getBankNumber;
import static com.donnatto.utils.Helpers.getTypeNumber;

public class Validator {

    public String calculateCCI(Bank bank, AccountType type, Account account) {

        String bankNumber = null;
        String typeNumber = null;
        String officeNumber = null;
        String accountNumber = null;
        String checkDigit = null;
        String response = null;

        try {
            bankNumber = getBankNumber(bank);
            typeNumber = getTypeNumber(type);
            officeNumber = account.getAccount().substring(0,3);
            accountNumber = account.getAccount().substring(3);

            if (accountNumber.length() < 12) {
                accountNumber = typeNumber + StringUtils.leftPad(accountNumber, 11, "0");
            }

            // Implement digit check algorithm


            response = bankNumber + officeNumber + accountNumber + checkDigit;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }


}
