/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapp.manager;

import com.bank.interest.Interest;
import com.bankapp.dto.BankAccount;
import com.bankapp.dto.CaSaAccount;
import com.bankapp.dto.DepositAccount;
import com.bankapp.dto.LoanAccount;
import com.bankapp.dto.Transactions;
import com.bankapp.interfaces.Deposit;

import com.bankapp.interfaces.Withdrawal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Rachana J Nayak
 */
public class AccountManager {

    private static AccountManager accountManager;

    /**
     * Create private constructor
     */
    private AccountManager() {

    }

    /**
     * Create a static method to get instance.
     *
     * @return
     */
    public static AccountManager getInstance() {
        if (accountManager == null) {
            accountManager = new AccountManager();
        }
        return accountManager;
    }

    ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    static Transactions[] listOfTransaction = new Transactions[10];
    static int totalNumberOfTransaction = 0;
    int noOfWithdrawals = 0;
    int noOfDeposits = 0;

    public ArrayList<BankAccount> accountsList() {

        CaSaAccount caSaAccount = new CaSaAccount("Person1", 5000, 1000121000001L, "Savings");
        LoanAccount loanAccount = new LoanAccount(7.0, "Rachana", 10000, 1000121000002L, "Vehicle");
        DepositAccount depositAccount = new DepositAccount(3.0, 7.75, "Anuradha", 45000, 1000121000000L, "Fixed deposit");
        bankAccounts.add(caSaAccount);
        bankAccounts.add(loanAccount);
        bankAccounts.add(depositAccount);
        return bankAccounts;

    }

    public void withdraw(long accountNo, double amount) {

        if (getAccount(accountNo) instanceof Withdrawal) {
            System.out.println("Right");
            Withdrawal withdrawal = (Withdrawal) getAccount(accountNo);
            double balance = getAccount(accountNo).getBalance();
            double currentBalance = withdrawal.withdraw(balance, amount);
            noOfWithdrawals++;
            getAccount(accountNo).setBalance(currentBalance);
            addTransaction("Money Withdrawal", "Withdraw", amount, currentBalance);

        }
    }

    public void deposit(long accountNo, double amount) {
        BankAccount bankAccount = getAccount(accountNo);
        if (bankAccount instanceof Deposit) {
            double balance = bankAccount.getBalance();
            Deposit deposit = (Deposit) bankAccount;
            double currentBalance = deposit.deposit(balance, amount);
            noOfDeposits++;
            getAccount(accountNo).setBalance(currentBalance);
            addTransaction("Money Deposition", "Deposit", amount, currentBalance);
        }
    }

    private BankAccount getAccount(long accountNo) {
        for (BankAccount bankAccount : accountsList()) {
            if (accountNo == bankAccount.getAccountNo()) {
                return bankAccount;

            }

        }
        return null;
    }

    public void addTransaction(String description, String type, double amount, double balance) {
        listOfTransaction[totalNumberOfTransaction++] = new Transactions(new SimpleDateFormat("dd-MM-yyyy").format(new Date()), description, type, amount, balance);
    }

    public void printAllTransactions() {
        System.out.println("No. of withdrawals:" + noOfWithdrawals);
        System.out.println("No. of deposits:" + noOfDeposits);
        System.out.println("Date \t Description \t type \t amount \t balance");

        for (int i = 0; i < totalNumberOfTransaction; i++) {
            Transactions t = listOfTransaction[i];
            System.out.println(t.getDate() + " " + t.getDescription() + " " + t.getType() + "  " + t.getAmount() + "  " + t.getBalance());
        }
    }
    
     public void addInterest(double rate, long accountNo) {
        
           
        double balance = getAccount(accountNo).getBalance();
        double interestAmount = (balance * rate);
        Interest interest = null ;
        double currentBalance=interest.addInterest(balance, rate);
        getAccount(accountNo).setBalance(currentBalance);
        addTransaction("Interest for 3 months", "Deposit", interestAmount, balance);

    }
         }


