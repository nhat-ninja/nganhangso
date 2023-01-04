package vn.funix.fx19041.java.asm03.models;

import vn.funix.fx19041.java.asm02.models.Account;

import static vn.funix.fx19041.java.asm03.models.Utils.getTitle;

public class LoanAccount extends Account implements ReportService, Withdraw {
    private final double LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;
    private final double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;
    private final double LOAN_ACCOUNT_MAX_BALANCE = 100000000;
    public LoanAccount(String accountNumber) {
        super(accountNumber, 100000000, "LOAN");
    }

    @Override
    public void log(double amount) {
        System.out.println(Utils.getDivider());
        System.out.printf("%34s%n", getTitle()+" LOANS");
        System.out.printf("NGAY G/D: %32s%n", Utils.getDateTime());
        System.out.printf("ATM ID: %34s%n","DIGITAL-BANK-ATM 2022");
        System.out.printf("SO TK: %35s%n" ,getAccountNumber());
        System.out.printf("SO TIEN: %32sđ%n" ,String.format( "%,d", (long) amount));
        System.out.printf("SO DU: %34sđ%n" ,String.format( "%,d", (long) getBalance()));
        System.out.printf("PHI + VAT: %30sđ%n" ,String.format( "%,d", (long) getFee(amount)));
        System.out.println(Utils.getDivider());
    }
    @Override
    public double getFee(double amount) {
      return amount * ((isPremium()) ? LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE : LOAN_ACCOUNT_WITHDRAW_FEE);
    }
    @Override
    public boolean withdraw(double amount) {
        Transaction transaction = new Transaction();
        transaction.setTime(Utils.getDateTime());
        if (isAccepted(amount)) {
            System.out.println("Rut tien thanh cong");
            setBalance(getBalance() - amount - getFee(amount));
//            setBalance(getBalance() - amount - amount * ((isPremium()) ? LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE : LOAN_ACCOUNT_WITHDRAW_FEE));
            transaction.setNumberAccount(getAccountNumber());
            transaction.setAmount(amount);
            transaction.setStatus(true);
            getTransactions().add(transaction);
            log(amount);
            return true;
        }
        transaction.setStatus(false);
        transaction.setNumberAccount(getAccountNumber());
        getTransactions().add(transaction);
        System.out.println("So tien rut khong duoc lon hon "+LOAN_ACCOUNT_MAX_BALANCE+"va so du sau khi rut khong duoc nho hon 50000d");
        return false;
    }

    @Override
    public boolean isAccepted(double amount) {
        return amount < LOAN_ACCOUNT_MAX_BALANCE && (getBalance() - amount >= 50000) && amount % 10000 == 0 && amount > 0;
    }


}
