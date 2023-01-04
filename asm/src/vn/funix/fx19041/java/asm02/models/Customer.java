package vn.funix.fx19041.java.asm02.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer extends User {
    private List<Account> accounts;

    public Customer(String name, String customerId, List<Account> accounts){
        super(name, customerId);
        this.accounts = new ArrayList<>();

    }
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Customer() {
        this.accounts = new ArrayList<>();
    }

    public Customer(String name, String customerId) {
        super(name, customerId);
        accounts = new ArrayList<>();
    }

    public boolean isPremium(){
        for (Account account : accounts) {
            return account.isPremium();
        }
       return false;
    }

    public void addAccount(Account newAccount) {
        for (Account account : accounts) {
            if (Objects.equals(newAccount.getAccountNumber(), account.getAccountNumber())) {
                System.out.println("Tai khoan da ton tai ");
                return;
            }
        }
        accounts.add(newAccount);
        System.out.println("Them tai khoan thanh cong");
    }

    public double getAllBalance() {
        double total=0;
        for (Account account : accounts) {
            total += account.getBalance();
        }
        return total;
    }

    public void displayInformation() {
        String isPre = (isPremium()) ? "Premium": "Normal";
        String newBalance = String.format( "%,d", (long) getAllBalance());
        System.out.printf("%-15s | %11s | %-15s | %15sđ\n",getCustomerId(),getName(),isPre,newBalance);
        for (int i = 0; i < accounts.size(); i++) {
            System.out.print(i + 1 + "     ");
            accounts.get(i).toStringAcc();
        }
        System.out.println(" ");
    }

    public void displayTransaction(){
        System.out.println("| So tai khoan  | So tien rut | Trang thai |   Thoi gian          |");
        for(Account account : accounts){
            account.displayTrans();
        }
    }
}