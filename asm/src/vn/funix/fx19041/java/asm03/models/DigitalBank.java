package vn.funix.fx19041.java.asm03.models;

import vn.funix.fx19041.java.asm02.models.Account;
import vn.funix.fx19041.java.asm02.models.Bank;
import vn.funix.fx19041.java.asm02.models.Customer;

import java.util.Objects;

public class DigitalBank extends Bank {

    public DigitalBank() {
    }

    public Customer getCustomerById(String customerId){
        for(int i = 0; i < getCustomers().size(); i++){
            if(Objects.equals(getCustomers().get(i).getCustomerId(), customerId)){
                return getCustomers().get(i);
            }
        }
        System.out.println("Khach hang chua dang ky");
        return null;
    }
    public void addCustomer(String name,String customerId){
        for(int i = 0; i < getCustomers().size(); i++){
            if(Objects.equals(getCustomers().get(i).getCustomerId(), customerId)){
                System.out.println("Khach hang da dang ky");
            }
        }
        DigitalCustomer newCustomer = new DigitalCustomer(name, customerId);
        this.addCustomer(newCustomer);
    }
    public void addAccount (String customerID, Account account) {
        for (Customer customer : getCustomers()) {
            if (customer.getCustomerId().equals((customerID))) {
                customer.addAccount(account);
                return;
            }
        }
    }

    public void Withdraw(String customerId,String accountNumber, double amount){
        for(Customer customer:getCustomers()){
            if(customer.getCustomerId().equals(customerId)){
                ((DigitalCustomer) customer).withdraw(accountNumber,amount);
                return;
            }
        }
        System.out.println("khach hang chua dang ky");
    }

}
