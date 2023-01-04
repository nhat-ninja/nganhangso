package vn.funix.fx19041.java.asm03.models;

import org.junit.jupiter.api.Test;
import vn.funix.fx19041.java.asm02.models.Customer;

import static org.junit.jupiter.api.Assertions.*;

class DigitalCustomerTest extends Customer {
    DigitalBank activeBank = new DigitalBank();

    @Test
    void testIsPremium() {
        activeBank.addCustomer(new Customer("NHAT","040098123123"));
        activeBank.addAccount("040098123123",new SavingsAccount("123123",500000));
        activeBank.addCustomer(new Customer("HIEU","040098123456"));
        activeBank.addAccount("040098123456",new LoanAccount("234234"));
        assertTrue(activeBank.getCustomerById("040098123456").isPremium());
        assertFalse(activeBank.getCustomerById("040098123123").isPremium());
        System.out.println("IsPremium tests passed");
    }

    @Test
    void testGetAllBalance() {
        activeBank.addCustomer(new Customer("NHAT","040098123123"));
        activeBank.addAccount("040098123123",new SavingsAccount("123123",5000000.0));
        activeBank.addAccount("040098123123",new SavingsAccount("121212",5000000.0));
        assertEquals(10000000.0,activeBank.getCustomerById("040098123123").getAllBalance());
        assertNotEquals(2000000.0,activeBank.getCustomerById("040098123123").getAllBalance());
        System.out.println("GetAllBalance tests passed");
    }

    @Test
    void testValidID() {
        assertTrue(DigitalCustomer.validID("092091000176"));
        assertFalse(DigitalCustomer.validID("000091000176"));
        System.out.println("testValidID tests passed");
    }
}