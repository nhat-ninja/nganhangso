package vn.funix.fx19041.java.asm02.models;

import vn.funix.fx19041.java.asm03.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private double balance;
    private String accountType;

    private List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getAccountType() {
        return accountType;
    }

    public Account() {
    }

    public Account(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public static boolean validAccNum(String accountNumber){
        return accountNumber.length() == 6 && accountNumber.matches("\\d+");
    }

    public void setAccountNumber(String accountNumber) {
        if(validAccNum(accountNumber)) {
            this.accountNumber = accountNumber;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Boolean isPremium(){
        return this.balance >= 10000000;
    }

    public void toStringAcc(){
        String newBalance = String.format( "%,d", (long) getBalance());
        System.out.printf("%s    | %46sđ\n", this.accountNumber, newBalance);
    }

    public void displayTrans(){
        if(getTransactions() != null){
            List<Transaction> transactions = new ArrayList<>(getTransactions());
            for (Transaction transaction : transactions) {
                System.out.print("[GD]  ");
                transaction.display();
            }
        }
    }
}
