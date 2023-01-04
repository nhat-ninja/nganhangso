package vn.funix.fx19041.java.asm03.models;

import vn.funix.fx19041.java.asm02.models.Customer;

import static org.junit.jupiter.api.Assertions.*;

class DigitalBankTest {
    DigitalBank activeBank = new DigitalBank();

    @org.junit.jupiter.api.Test
    void getCustomerById() {
        activeBank.addCustomer(new Customer("NHAT","040098123123"));
        assertEquals("NHAT",activeBank.getCustomerById("040098123123").getName());
        assertNull(activeBank.getCustomerById("050089234123"));
        assertNotNull(activeBank.getCustomerById("040098123123"));
        System.out.println("getCustomerById tests passed");
    }

    @org.junit.jupiter.api.Test
    void isCustomerExisted() {
        activeBank.addCustomer(new Customer("NHAT","040098123123"));
        assertTrue(activeBank.isCustomerExisted("040098123123"));
        assertFalse(activeBank.isCustomerExisted("030098123456"));
        System.out.println("isCustomerExisted tests passed");
    }

    @org.junit.jupiter.api.Test
    void isAccountExisted() {
        activeBank.addCustomer(new Customer("NHAT","040098123123"));
        activeBank.addAccount("040098123123",new SavingsAccount("123123",500000));
        activeBank.addAccount("040098123123",new LoanAccount("123321"));
        assertTrue(activeBank.isAccountExisted("123123"));
        assertFalse(activeBank.isCustomerExisted("098765"));
        assertTrue(activeBank.isAccountExisted("123321"));
        System.out.println("isAccountExisted tests passed");
    }
}