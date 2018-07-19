/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

import com.bankapp.manager.AccountManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Rachana J Nayak
 */
public class AccountController {

    public static void main(String[] args) {
        AccountManager accountManager = AccountManager.getInstance();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to UDUPI BANK");
        System.out.println("Enter the account number:");
        long accNo = 0;

        try {
            accNo = Long.parseLong(br.readLine());
            accountManager.deposit(accNo, 2000);
            accountManager.withdraw(accNo, 1000);
            accountManager.printAllTransactions();

        } catch (Exception e) {

            System.out.println("Wrong account number!");
            System.out.println("Wrong number please check again");

        }

    }

}
