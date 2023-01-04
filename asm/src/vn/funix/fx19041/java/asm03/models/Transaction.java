package vn.funix.fx19041.java.asm03.models;

import java.util.UUID;

public class Transaction {
    private final String id;
    private String numberAccount;
    private double amount;
    private boolean status;
    private String time;

    public Transaction() {
        this.id=String.valueOf(UUID.randomUUID());
    }
    public String getId() {
        return id;
    }
    public String getNumberAccount() {
        return numberAccount;
    }
    public double getAmount() {
        return amount;
    }
    public boolean isStatus() {
        return status;
    }
    public String getTime() {
        return time;
    }
    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void display(){
        String isSta = isStatus()? "Thanh Cong": "That Bai";
        String newAmount = String.format( "%,d", (long) getAmount());
        System.out.printf("%-9s | %11s | %-10s | %15s\n",
                getNumberAccount(),newAmount,isSta,getTime());
    }
}
