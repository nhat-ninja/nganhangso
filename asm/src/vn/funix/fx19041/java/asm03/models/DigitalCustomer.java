package vn.funix.fx19041.java.asm03.models;

import vn.funix.fx19041.java.asm02.models.Account;
import vn.funix.fx19041.java.asm02.models.Customer;

import java.util.List;
import java.util.Objects;

public class DigitalCustomer extends Customer {
    public DigitalCustomer(String name, String customerId, List<Account> accounts){
        super(name, customerId, accounts);
    }

    public DigitalCustomer(String name, String customerId) {
        super(name, customerId);
    }

    public void addAccount(Account account){
        for(int i = 0; i < getAccounts().size(); i++){
            if(Objects.equals(getAccounts().get(i).getAccountNumber(), account.getAccountNumber())){
                System.out.println("So tai khoan da ton tai");
                return;
            }
        }
        getAccounts().add(account);
        System.out.println("Da them tai khoan moi");

    }

    @Override
    public void displayInformation() {
        String isPre = (isPremium()) ? "Premium" : "Normal";
        String newBalance = String.format( "%,d", (long) getAllBalance());
        System.out.printf("%-15s | %11s | %-10s | %15sđ\n", getCustomerId(), getName(), isPre , newBalance);
        List<Account> accounts = this.getAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            String accBalance = String.format( "%,d", (long) accounts.get(i).getBalance());
            System.out.print(i + 1 + "     ");
            System.out.printf("%-9s | %11s | %-10s | %15sđ\n", accounts.get(i).getAccountNumber(), accounts.get(i).getAccountType(), "", accBalance);
        }
    }

    public void withdraw(String accountNumber, double amount) {
        for(Account account: getAccounts()){
            if(account.getAccountNumber().equals(accountNumber)){
                if(account instanceof SavingsAccount){
                    ((SavingsAccount) account).withdraw(amount);
                } else if (account instanceof LoanAccount) {
                    ((LoanAccount) account).withdraw(amount);
                }
            }
        }
    }


}
