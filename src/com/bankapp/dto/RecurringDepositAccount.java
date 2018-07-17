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
public class RecurringDepositAccount extends DepositAccount implements Deposit{

    public RecurringDepositAccount(double term, double rate, String name, double balance, long accountNo, String accountType) {
        super(term, rate, name, balance, accountNo, accountType);
    }

    @Override
    public double deposit(double balance, double amount) {
        return balance += amount;
    }
    
}
