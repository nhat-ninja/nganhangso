package vn.funix.fx19041.java.asm03.models;

import vn.funix.fx19041.java.asm02.models.Account;

import static vn.funix.fx19041.java.asm03.models.Utils.getTitle;

public class SavingsAccount extends Account implements ReportService, Withdraw{
    private final double SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance, "SAVING");
    }


    @Override
    public void log(double amount) {
        System.out.println(Utils.getDivider());
        System.out.printf("%34s%n", getTitle()+" SAVING");
        System.out.printf("NGAY G/D: %32s%n", Utils.getDateTime());
        System.out.printf("ATM ID: %34s%n","DIGITAL-BANK-ATM 2022");
        System.out.printf("SO TK: %35s%n" ,getAccountNumber());
        System.out.printf("SO TIEN: %32sđ%n" ,String.format( "%,d", (long) amount));
        System.out.printf("SO DU: %34sđ%n" ,String.format( "%,d", (long) getBalance()));
        System.out.printf("PHI + VAT: %30sđ%n" ,String.format( "%,d", (long) getFee(amount)));
        System.out.println(Utils.getDivider());
    }

    @Override
    public boolean withdraw(double amount) {
        Transaction transaction = new Transaction();
        transaction.setTime(Utils.getDateTime());
        if(isAccepted(amount)){
            System.out.println("Rut tien thanh cong");
            setBalance(getBalance() - amount);
            log(amount);
            transaction.setNumberAccount(getAccountNumber());
            transaction.setAmount(amount);
            transaction.setStatus(true);
            getTransactions().add(transaction);
            return true;
        }
        System.out.println("So tien khong kha dung");
        System.out.println("CHU Y:\n- So tine rut ra phai lon hon 50000d va la so chia het cho 10000");
        System.out.println("- So du sau khi rut phai lon hon 50000d");
        System.out.println("- Doi voi khong phai tai khoan premium se chi duoc rut "+ SAVINGS_ACCOUNT_MAX_WITHDRAW+" tren mot ngay");
        transaction.setStatus(false);
        transaction.setNumberAccount(getAccountNumber());
        getTransactions().add(transaction);
        return false;
    }

    @Override
    public boolean isAccepted(double amount) {
        double afterWithdrawBalance = getBalance() - amount;
        if(!isPremium()){
            return amount >= 50000 && amount <= SAVINGS_ACCOUNT_MAX_WITHDRAW && amount % 10000 == 0 && afterWithdrawBalance >= 50000;
        }else if(isPremium()){
            return amount >= 50000 && amount % 10000 == 0 && afterWithdrawBalance>= 50000;
        }else{
            return false;
        }
    }
    public double getFee(double amount) {
        return amount*0;
    }
}
