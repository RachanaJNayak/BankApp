/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapp.dto;

import com.bankapp.interfaces.Deposit;

/**
 *
 * @author Rachana J Nayak
 */
public class LoanAccount extends BankAccount implements Deposit{

    private double rate;

    public LoanAccount(double rate, String name, double balance, long accountNo, String accountType) {
        super(name, balance, accountNo, accountType);

        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public double deposit(double balance, double amount) {
        return balance+=amount;
    }

}
