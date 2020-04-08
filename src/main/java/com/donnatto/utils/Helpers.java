package com.donnatto.utils;

import com.donnatto.model.AccountType;
import com.donnatto.model.Bank;

public class Helpers {

    public static String getTypeNumber(AccountType type) throws Exception {
        switch (type) {
            case CTA_CORRIENTE:
                return "0";
            case AHORROS:
                return "1";
            default:
                throw new Exception("Account type is not valid");
        }
    }

    public static String getBankNumber(Bank bank) throws Exception {
        switch (bank) {
            case BCP:
                return  "002";
            case BCP2:
                return "800";
            case INTERBANK:
                return  "003";
            case SCOTIABANK:
                return  "009";
            default:
                throw new Exception("Bank is not valid");
        }
    }
}
