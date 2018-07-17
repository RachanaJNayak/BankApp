/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapp.dto;

/**
 *
 * @author Rachana J Nayak
 */
public class Transactions {
    private String date;
    private String description;
    private String type;
    private double amount;
    private double balance;

    public Transactions(String date, String description, String type, double amount, double balance) {
        this.date = date;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
    
}
