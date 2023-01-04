package vn.funix.fx19041.java.asm03.models;

import org.junit.jupiter.api.Test;
import vn.funix.fx19041.java.asm02.models.Account;
import vn.funix.fx19041.java.asm02.models.Customer;

import static org.junit.jupiter.api.Assertions.*;

class LoanAccountTest extends Customer {

    @Test
    void validAccNum() {
        assertTrue(SavingsAccount.validAccNum("232323"));
        assertTrue(SavingsAccount.validAccNum("232323"));
        assertFalse(SavingsAccount.validAccNum("2323231"));
        System.out.println("validAccNum test passed");
    }

    @Test
    void testIsPremium() {
        Account account = new LoanAccount("123456");
        assertTrue(account.isPremium());
    }

    @Test
    void withdraw() {
        LoanAccount account = new LoanAccount("123321");
        assertTrue(account.withdraw(10000));
        assertTrue(account.withdraw(10000000));
        assertFalse(account.withdraw(-400000));
        System.out.println("withdraw test passed");
    }

    @Test
    void isAccepted() {
        LoanAccount account = new LoanAccount("123321");
        assertTrue(account.withdraw(10000));
        assertTrue(account.withdraw(10000000));
        assertFalse(account.withdraw(-400000));
        assertFalse(account.withdraw(1000040));
        assertFalse(account.withdraw(95560000));
        System.out.println("isAccepted test passed");
    }

    @Test
    void getFee() {
        LoanAccount account3 = new LoanAccount("789789");
        assertEquals(0.01*10000000,account3.getFee(10000000.0));
        account3.withdraw(91000000);
        assertEquals(0.05*1000000,account3.getFee(1000000.0));
    }
}