package vn.funix.fx19041.java.asm03.models;

//import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import vn.funix.fx19041.java.asm02.models.Account;
import vn.funix.fx19041.java.asm02.models.Customer;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest extends Customer {
    @Test
    void validAccNum() {
        assertTrue(SavingsAccount.validAccNum("232323"));
        assertTrue(SavingsAccount.validAccNum("232323"));
        assertFalse(SavingsAccount.validAccNum("2323231"));
        System.out.println("validAccNum test passed");
    }

    @Test
    void testIsPremium() {
        Account account = new SavingsAccount("123123",50000000.0);
        assertTrue(account.isPremium());
        account.setBalance(100000);
        assertFalse(account.isPremium());
        System.out.println("isPremium test passed");
    }

    @Test
    void withdraw() {
        SavingsAccount account1 = new SavingsAccount("123123",50000000.0);
        SavingsAccount account2 = new SavingsAccount("123123",9000000.0);
        assertFalse(account1.withdraw(40000));
        assertFalse(account1.withdraw(-400000));
        assertTrue(account1.withdraw(6000000));
        assertFalse(account2.withdraw(600001));
        assertFalse(account2.withdraw(6000000));
        assertTrue(account2.withdraw(5000000));
        System.out.println("withdraw test passed");
    }

    @Test
    void isAccepted() {
        SavingsAccount account1 = new SavingsAccount("123123",50000000.0);
        SavingsAccount account2 = new SavingsAccount("123123",9000000.0);
        assertFalse(account1.withdraw(40000));
        assertFalse(account1.withdraw(-400000));
        assertTrue(account1.withdraw(6000000));
        assertFalse(account2.withdraw(600001));
        assertFalse(account2.withdraw(6000000));
        assertTrue(account2.withdraw(5000000));
        System.out.println("isAccepted test passed");
    }

    @Test
    void getFee() {
        SavingsAccount account2 = new SavingsAccount("123123",9000000.0);
        assertEquals(0,account2.getFee(100000));
        assertEquals(0,account2.getFee(10000000));
    }
}