package com.donnatto;

import com.donnatto.model.AccountType;
import com.donnatto.model.Bank;
import org.apache.commons.lang3.StringUtils;

import static com.donnatto.utils.Helpers.getBankNumber;
import static com.donnatto.utils.Helpers.getTypeNumber;

public class Validator {

    public String calculateCCI(Bank bank, AccountType type, String account) {

        String bankNumber;
        String typeNumber;
        String officeNumber;
        String accountNumber;
        String checkDigit;
        String response = null;

        try {
            bankNumber = getBankNumber(bank);
            typeNumber = getTypeNumber(type);
            officeNumber = account.substring(0, 3);
            accountNumber = account.substring(3);

            // Only valid with BCP
            if (accountNumber.length() < 12) {
                accountNumber = typeNumber + StringUtils.leftPad(accountNumber, 11, "0");
            }

            // Implement digit check algorithm
            String firstDigit = calcDigits(bankNumber, officeNumber);
            String secondDigit = calcDigits(accountNumber);

            checkDigit = firstDigit + secondDigit;

            response = bankNumber + officeNumber + accountNumber + checkDigit;

            System.out.println("First digit -> " + firstDigit);
            System.out.println("Second digit -> " + secondDigit);
            System.out.println("CCI is -> " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    private String calcDigits(String... args) {

        String response = null;
        StringBuilder input = new StringBuilder();

        try {
            for (String arg : args) {
                input.append(arg);
            }

            char[] chars = input.toString().toCharArray();
            int length = chars.length;
            int[] numbers = new int[length];
            int sum = 0;
            int result;

            for (int i = 0; i < length; i++) {
                numbers[i] = Character.getNumericValue(chars[i]);
                numbers[i] = i % 2 == 0 ? numbers[i] : numbers[i] * 2;
                numbers[i] = numbers[i] > 9 ? 1 + numbers[i] % 10 : numbers[i];
                sum += numbers[i];
            }
            result = sum % 10 == 0 ? 0 : 10 - sum % 10;

            response = String.valueOf(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

}
