package com.donnatto;


import com.donnatto.model.AccountType;
import com.donnatto.model.Bank;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        File input = new File("./src/main/resources/accounts.txt");
        File output = new File("./src/main/resources/new-accounts.txt");

        Scanner sc = new Scanner(input);
        Validator validator = new Validator();
        FileWriter writer = new FileWriter(output);
        PrintWriter printWriter = new PrintWriter(writer);
        String line;

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String cci = validator.calculateCCI(Bank.BCP2, AccountType.AHORROS, line);
            printWriter.println(line + " - CCI -> " + cci);
        };
        printWriter.close();

    }
}
