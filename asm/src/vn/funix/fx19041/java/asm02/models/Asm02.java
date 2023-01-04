package vn.funix.fx19041.java.asm02.models;

import java.util.Objects;
import java.util.Scanner;

public class Asm02 {
    private static final Bank bank = new Bank();
    public static Scanner sc = new Scanner(System.in);
    public static final String AUTHOR = "FX19041";

    public static final String VERSION = "@v2.0.0";
    public static void main(String[] args) {
        System.out.println("+----------+--------------------+---------+");
        System.out.println("| デジタル銀行 | " + AUTHOR + VERSION + "           |");
        System.out.println("+----------+--------------------+---------+");
        do{
            menu();
        }while(checkIn());
    }
    public static void menu(){
        System.out.println(" 1. お客様追加");
        System.out.println(" 2. 口座追加");
        System.out.println(" 3. お客様のリスト");
        System.out.println(" 4. マイナンバーで検索");
        System.out.println(" 5. 名前で検索");
        System.out.println(" 0.　終了");
        System.out.println("+----------+--------------------+---------+");
        System.out.println("機能選択: ");
    }
    public static boolean checkIn() {
        try{
            int number = Integer.parseInt(sc.nextLine());
            switch (number){
                case 0:
                    System.out.println("bye bye!");
                    return false;
                case 1://add new customer
                    System.out.println("Nhap ten khach hang:");
                    String cusName = sc.nextLine();
                    while(!User.validName(cusName)){
                        System.out.println("Nhap lai! Ten phai co tren hai chu cai va khong chua so!");
                        cusName = sc.nextLine();
                    }
                    System.out.println("Nhap so CCCD:");
                    String cusNumber = sc.nextLine();
                    while(!User.validID(cusNumber)){
                        System.out.println("Nhap lai! CCCD khong hop le!");
                        cusNumber = sc.nextLine();
                    }
                    Customer newCus = new Customer();
                    newCus.setName(cusName);
                    newCus.setCustomerId(cusNumber);
                    bank.addCustomer(newCus);
                    return true;
                case 2://add new account
                    System.out.println("Nhap so CCCD:");
                    String nowCusNumber = sc.nextLine();
                    while(!User.validID(nowCusNumber)){
                        System.out.println("Nhap lai! CCCD khong hop le!");
                        nowCusNumber = sc.nextLine();
                    }
                    if(bank.isCustomerExisted(nowCusNumber)){
                        System.out.println("Nhap ma STK gom 6 chu so");
                        String stkNumber = sc.nextLine();
                        while(!Account.validAccNum(stkNumber)){
                            System.out.println("STK co 6 so va khong chua chu cai");
                            stkNumber = sc.nextLine();
                        }
                        System.out.println("Nhap so du");
                        double balanceNum = sc.nextDouble();
                        sc.nextLine();
                        while(balanceNum < 50000){
                            System.out.println("Nhap lai! so du phai lon hon 50000");
                            balanceNum = sc.nextDouble();
                            sc.nextLine();
                        }
                        Account account1 = new Account();
                        account1.setAccountNumber(stkNumber);
                        account1.setBalance(balanceNum);
                        bank.addAccount(nowCusNumber,account1);
                    }else {
                        System.out.println("khac hang chu duoc them vao");
                    }
                    return true;
                case 3: //print all customer information
                    for (int i = 0; i < bank.getCustomers().size(); i++) {
                        bank.getCustomers().get(i).displayInformation();
                    }
                    return true;
                case 4: //search customer
                    System.out.println("Nhap so CCCD can tim");
                    String inCustomerNumber = sc.nextLine();
                    searchCustomerById(inCustomerNumber);
                    return true;
                case 5:// search customer
                    System.out.println("Nhap ten khach hang can tim:");
                    String inCustomerName = sc.nextLine();
                    searchCustomerByName(inCustomerName);
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
    //    search custom mer by ID method
    public static void searchCustomerById(String inCustomerNumber){
        for (int i = 0; i < bank.getCustomers().size(); i++) {
            if (Objects.equals(inCustomerNumber, bank.getCustomers().get(i).getCustomerId())) {
                bank.getCustomers().get(i).displayInformation();
            }
        }
    }

    //    search custom mer by name method
    public static void searchCustomerByName(String inCustomerName){
        for (int i = 0; i < bank.getCustomers().size(); i++) {
            String customerSaveName = bank.getCustomers().get(i).getName();
            if (customerSaveName.contains(inCustomerName)) {
                bank.getCustomers().get(i).displayInformation();
            }
        }
    }

}