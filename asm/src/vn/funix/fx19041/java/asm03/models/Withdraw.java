package vn.funix.fx19041.java.asm03.models;

public interface Withdraw {
    double getFee(double amount);

    boolean withdraw(double amount);
    boolean isAccepted(double amount);
}
