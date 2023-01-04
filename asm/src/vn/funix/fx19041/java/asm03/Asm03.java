package vn.funix.fx19041.java.asm03;

import vn.funix.fx19041.java.asm02.models.Account;
import vn.funix.fx19041.java.asm02.models.Customer;
import vn.funix.fx19041.java.asm02.models.User;
import vn.funix.fx19041.java.asm03.models.DigitalBank;
import vn.funix.fx19041.java.asm03.models.LoanAccount;
import vn.funix.fx19041.java.asm03.models.SavingsAccount;

import java.util.Scanner;

public class Asm03 {
    private static final int EXIT_COMMAND_CODE = 0;
    private static final int EXIT_ERROR_CODE = -1;
    private static final Scanner sc = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_ID ="040098123789";
    private static final String CUSTOMER_NAME = "NHATLE";

    public static void main(String[] args){
        System.out.println("+----------+--------------------+---------+");
        System.out.println("| デジタル銀行 | FX14041@v3.0.0           |");
        System.out.println("+----------+--------------------+---------+");
        activeBank.addCustomer(CUSTOMER_NAME,CUSTOMER_ID);
        do{
            menu();
        }while(checkIn());
    }
    public static void menu(){
        System.out.println(" 1. お客様情報");
        System.out.println(" 2. ATM口座追加");
        System.out.println(" 3. ローン口座追加");
        System.out.println(" 4. 引き出し");
        System.out.println(" 5. 取引履歴");
        System.out.println(" 0. 終了");
        System.out.println("+----------+--------------------+---------+");
        System.out.println("機能選択: ");
    }
    public static void showCustomer(){
        Customer customer = activeBank.getCustomerById(CUSTOMER_ID);
        if (customer!=null)
            customer.displayInformation();
        else
            System.out.println("Khong tim thay khach hang");
    }
    public static boolean checkIn() {
        try{
            int number = Integer.parseInt(sc.nextLine());
            System.out.println("Da chon chuc nang: "+ number);
            switch (number){
                case 0:
                    System.out.println("bye bye!");
                    return false;
                case 1:
                    showCustomer();
                    return true;
                case 2:
                    System.out.println("Nhap ma STK gom 6 chu so");
                    String atmNumber = sc.nextLine();
                    while(!Account.validAccNum(atmNumber)){
                        System.out.println("STK co 6 so va khong chua chu cai");
                        atmNumber = sc.nextLine();
                    }
                    System.out.println("Nhap so du");
                    double balanceNum = sc.nextDouble();
                    sc.nextLine();
                    while(balanceNum < 50000){
                        System.out.println("Nhap lai! so du phai lon hon 50000");
                        balanceNum = sc.nextDouble();
                        sc.nextLine();
                    }
                    Account savingsAccount = new SavingsAccount(atmNumber,balanceNum);
                    activeBank.addAccount(CUSTOMER_ID,savingsAccount);
                    return true;
                case 3:
                    System.out.println("Nhap ma STK gom 6 chu so");
                    String loanNumber = sc.nextLine();
                    while(!Account.validAccNum(loanNumber)){
                        System.out.println("STK co 6 so va khong chua chu cai");
                        loanNumber = sc.nextLine();
                    }
                    Account loanAccount = new LoanAccount(loanNumber);
                    activeBank.addAccount(CUSTOMER_ID,loanAccount);
                    return true;
                case 4:
                    System.out.println("Nhap so CCCD:");
                    String cusNumber = sc.nextLine();
                    while(!User.validID(cusNumber)){
                        System.out.println("Nhap lai! CCCD khong hop le!");
                        cusNumber = sc.nextLine();
                    }
                    System.out.println("Nhap tai khoan muon rut");
                    String stkNumber = sc.nextLine();
                    while(!Account.validAccNum(stkNumber)){
                        System.out.println("STK co 6 so va khong chua chu cai");
                        stkNumber = sc.nextLine();
                    }
                    System.out.println("Nhap so tien muon rut");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    activeBank.Withdraw(cusNumber,stkNumber,amount);
                    return true;
                case 5:
                    displayTrans();
                    return true;
                default:
                    System.out.println("Vui long nhap so hop le tu 0 den 5!!!");
                    return true;
            }
        }catch (Exception e){
            System.out.println("Nhap lai");
        }
        return true;
    }

    public static void displayTrans(){
        Customer customer = activeBank.getCustomerById(CUSTOMER_ID);
        customer.displayInformation();
        customer.displayTransaction();
    }


}
