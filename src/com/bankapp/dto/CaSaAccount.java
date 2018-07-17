/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapp.dto;

import com.bankapp.interfaces.Deposit;
import com.bankapp.interfaces.Withdrawal;

/**
 *
 * @author Rachana J Nayak
 */
public class CaSaAccount extends BankAccount implements Withdrawal,Deposit{

    public CaSaAccount(String name, double balance, long accountNo, String accountType) {
        super(name, balance, accountNo, accountType);
    }

    public CaSaAccount() {

    }

    @Override
    public double withdraw(double balance, double amount) {
        return balance-=amount;
    }

    @Override
    public double deposit(double balance, double amount) {
        return balance+=amount;
    }

}
