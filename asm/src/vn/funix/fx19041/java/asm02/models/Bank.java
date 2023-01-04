package vn.funix.fx19041.java.asm02.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Bank {
    private final String id;
    private final List<Customer> customers;

    public Bank() {
        customers = new ArrayList<>();
        this.id=String.valueOf(UUID.randomUUID());
    }

    public String getId() {
        return id;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer newCustomer) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (Objects.equals(newCustomer.getCustomerId(), customers.get(i).getCustomerId())) {
                System.out.println("Khach hang da dang ky !");
                return;
            }
        }
        customers.add(newCustomer);
//        System.out.println("Them khach hang thanh cong");
    }

    public void addAccount(String customerId, Account account) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (Objects.equals(customerId, customers.get(i).getCustomerId())) {
                customers.get(i).addAccount(account);
            }
        }
    }

    public boolean isCustomerExisted(String customerId) {
        for (Customer customer : customers) {
            if (Objects.equals(customerId, customer.getCustomerId())) {
                return true;
            }
        }
        return false;
    }

    public boolean isAccountExisted(String accountNumber) {
        for (Customer customer: customers) {
            for(Account account:customer.getAccounts())
                if(account.getAccountNumber().equals(accountNumber)){
                    return true;
                }
            return false;
        }
        return false;
    }

}
