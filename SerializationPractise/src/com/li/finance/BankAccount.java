package com.li.finance;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BankAccount implements Serializable {
    private String id;
    private int balance = 0;
    private char lastTxType;
    private int lastTxAmount;
    private static final long serialVersionUID = 1234L;


    public BankAccount(String id){
        this.id = id;
    }

    public BankAccount(String id, int balance){
        this.id = id;
        this.balance = balance;
    }

    // other members elided
    public synchronized void deposit(int amount){
        balance += amount;
        lastTxType = 'd';
        lastTxAmount = amount;
    }

    public synchronized void withdrawal(int amount){
        balance -= amount;
        lastTxType = 'w';
        lastTxAmount = amount;
    }
    public String getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public char getLastTxType() {
        return lastTxType;
    }

    public int getLastTxAmount() {
        return lastTxAmount;
    }

    private void writeObject(ObjectOutputStream output) throws IOException {
        output.defaultWriteObject();
    }

    private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = input.readFields();
        id = (String) fields.get("id",null);
        balance = fields.get("balance",0);
        lastTxType = fields.get("lastTxType",'u');
        lastTxAmount = fields.get("lastTxAmount",-1);

    }
}
