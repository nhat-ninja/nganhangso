package vn.funix.fx19041.java.asm01;

import java.util.Random;
import java.util.Scanner;


public class Asm01 {
    private static String myNewNumber;
    private static final Scanner scanner = new Scanner(System.in);
    public static final String AUTHOR = "NGAN HANG SO";
    public static final String VERSION = "FX19041@v1.0.0";
    //start
    public static void main(String[] args) {
        System.out.println("+----------+--------------------+---------+");
        System.out.println("| "+AUTHOR+" | "+VERSION+"           |");
        System.out.println("+----------+--------------------+---------+");
        System.out.println("| 1. Nhap CCCD                            |");
        System.out.println("| 2. Thoat                                |");
        System.out.println("+----------+--------------------+---------+");
        System.out.println("Nhap CCCD de tim hieu trong thong tin chi tiet ");
        System.out.println("Chuc Nang: ");
        checkNumber();
    }
    //   chon chuc nang
    public static void checkNumber(){
        String number = scanner.nextLine();
        try {
            int numbers = Integer.parseInt(number);
            if (numbers == 0) {
                System.out.println("Goodbye!");
            } else if (numbers == 1) {
                easyAndHard();
            } else {
                System.out.println("Loi! Hay nhap lai");
                checkNumber();
            }
        } catch(Exception e){
            System.out.println("nhap lai");
            checkNumber();
        }

    }
    public static void easyAndHard(){
        System.out.println("vui long chon che do");
        System.out.println("| 1. EASY");
        System.out.println("| 2. HARD");
        String mode = scanner.nextLine();
        try {
            Integer.parseInt(mode);
            if (mode.equals("1")) {
                checkPassNumberEasy();
            } else if (mode.equals("2")) {
                checkPassNumberHard();
            } else {
                System.out.println("nhap lai");
                easyAndHard();
            }
        }catch(Exception e){
            System.out.println("nhap lai");
            easyAndHard();
        }
    }

    //random pass
    public static void checkPassNumberEasy() {
        int randomNumber = (int)((Math.random()*899)+100);
        String newRandomNumber = String.valueOf(randomNumber);
        System.out.println("Nhap ma xac thuc :" + randomNumber);
        String passNumberIn = scanner.nextLine();
        try {
            Integer.parseInt(passNumberIn);
            if (passNumberIn.equals(newRandomNumber)) {
                inMyNumber();
            } else {
                System.out.println("Sai ma! Vui long nhap lai!");
                checkPassNumberEasy();
            }
        } catch (Exception e){
            System.out.println("Sai ma! Vui long nhap lai!");
            checkPassNumberEasy();
        }
    }
    public static void checkPassNumberHard() {
        String alpha = "abcdefghijklmnopqrstuvwxyz"; //a-z
        String alphaUpperCase = alpha.toUpperCase();//A-Z
        String digits = "0123456789";//0-9
        String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
        // create random string builder
        StringBuilder sb = new StringBuilder();
        // create an object of Random class
        Random random = new Random();
        // specify length of random string
        int length = 6;
        for (int i = 0; i<length;i++){
            int index = random.nextInt(ALPHA_NUMERIC.length());
            char randomChar = ALPHA_NUMERIC.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        System.out.println("Nhap ma xac thuc :" + randomString);
        String passNumberIn = scanner.nextLine();

        if(passNumberIn.equals(randomString)){
            inMyNumber();
        }else{
            System.out.println("Sai ma! Vui long nhap lai!");
            checkPassNumberHard();
        }
    }
    //    check cccd
    public static void inMyNumber(){
        System.out.println("Vui long nhap so CCCD:");
        String myNumber = scanner.nextLine();
        myNewNumber = myNumber;
        if (myNumber.length() == 12 && myNumber.matches("\\d+")) {
            checkInformation();
        }else if(myNumber.equals("No")){
            System.out.println("bye!");
        } else {
            System.out.println("So CCCD khong hop le");
            System.out.println("Vui long nhap lai hoac nhan 'No' de thoat!");
            inMyNumber();
        }

    }

    //check information
    public static void checkInformation() {
        System.out.println("| 1. Kiem tra noi sinh");
        System.out.println("| 2. Kiem tra gioi tinh, nam sinh");
        System.out.println("| 3. Kiem tra so ngau nhien");
        System.out.println("| 0. Thoat");
        System.out.println("Ban muon kiem tra dieu gi?");
        String checkMyInfo = scanner.next();
        try {
            Integer.parseInt(checkMyInfo);
            switch (checkMyInfo) {
                case "1":   placeBirth();   break;
                case "2":   ageAndSex();    break;
                case "3":   myRandomNumber();   break;
                case "0":   System.out.println("Bye!");break;
                default:
                    System.out.println("Xin hay nhap lai");
                    checkInformation();
                    break;
            }
        }catch (Exception e){
            System.out.println("Xin hay nhap lai");
            checkInformation();
        }

    }
    // noi sinh
    public static void placeBirth(){
        String threeNumber =myNewNumber.substring(0,3);
        int newThreeNumber = Integer.parseInt(threeNumber);
        switch (newThreeNumber){
            case 1:	    System.out.println("Noi sinh:Ha Noi");	    break;
            case 2:	    System.out.println("Noi sinh:Ha Giang");	break;
            case 4:	    System.out.println("Noi sinh:Cao Bang");	break;
            case 6:	    System.out.println("Noi sinh:Bac Kan"); 	break;
            case 8:	    System.out.println("Noi sinh:Tuyen Quang");	break;
            case 10:	System.out.println("Noi sinh:Lao Cai");	    break;
            case 11:	System.out.println("Noi sinh:Dien Bien");	break;
            case 12:	System.out.println("Noi sinh:Lai Chau");	break;
            case 14:	System.out.println("Noi sinh:Son La");	    break;
            case 15:	System.out.println("Noi sinh:Yen Bai"); 	break;
            case 17:	System.out.println("Noi sinh:Hoa Binh");	break;
            case 19:	System.out.println("Noi sinh:Thai Nguyen");	break;
            case 20:	System.out.println("Noi sinh:Lang Son");	break;
            case 22:	System.out.println("Noi sinh:Quang Ninh");	break;
            case 24:	System.out.println("Noi sinh:Bac Giang");	break;
            case 25:	System.out.println("Noi sinh:Phu Tho");	    break;
            case 26:	System.out.println("Noi sinh:Vinh Phuc");	break;
            case 27:	System.out.println("Noi sinh:Bac Ninh");	break;
            case 30:	System.out.println("Noi sinh:Hai Duong");	break;
            case 31:	System.out.println("Noi sinh:Hai Phong");	break;
            case 33:	System.out.println("Noi sinh:Hung Yen");	break;
            case 34:	System.out.println("Noi sinh:Thai Binh");	break;
            case 35:	System.out.println("Noi sinh:Ha Nam");	    break;
            case 36:	System.out.println("Noi sinh:Nam Dinh");	break;
            case 37:	System.out.println("Noi sinh:Ninh Binh");	break;
            case 38:	System.out.println("Noi sinh:Thanh Hoa");	break;
            case 40:	System.out.println("Noi sinh:Nghe An");	    break;
            case 42:	System.out.println("Noi sinh:Ha Tinh");	    break;
            case 44:	System.out.println("Noi sinh:Quang Binh");	break;
            case 45:	System.out.println("Noi sinh:Quang Tri");	break;
            case 46:	System.out.println("Noi sinh:Thua Thien Hue");	break;
            case 48:	System.out.println("Noi sinh:Da Nang");	    break;
            case 49:	System.out.println("Noi sinh:Quang Nam");	break;
            case 51:	System.out.println("Noi sinh:Quang Ngai");	break;
            case 52:	System.out.println("Noi sinh:Binh Dinh");	break;
            case 54:	System.out.println("Noi sinh:Phu Yen"); 	break;
            case 56:	System.out.println("Noi sinh:Khanh Hoa");	break;
            case 58:	System.out.println("Noi sinh:Ninh Thuan");	break;
            case 60:	System.out.println("Noi sinh:Binh Thuan");	break;
            case 62:	System.out.println("Noi sinh:Kon Tum");	    break;
            case 64:	System.out.println("Noi sinh:Gia Lai");	    break;
            case 66:	System.out.println("Noi sinh:Dak Lak");	    break;
            case 67:	System.out.println("Noi sinh:Dak Nong");	break;
            case 68:	System.out.println("Noi sinh:Lam Dong");	break;
            case 70:	System.out.println("Noi sinh:Binh Phuoc");	break;
            case 72:	System.out.println("Noi sinh:Tay Ninh");	break;
            case 74:	System.out.println("Noi sinh:Binh Duong");	break;
            case 75:	System.out.println("Noi sinh:Dong Nai");	break;
            case 77:	System.out.println("Noi sinh:Ba Ria - Vung Tau");	break;
            case 79:	System.out.println("Noi sinh:Ho Chi Minh");	break;
            case 80:	System.out.println("Noi sinh:Long An");	    break;
            case 82:	System.out.println("Noi sinh:Tien Giang");	break;
            case 83:	System.out.println("Noi sinh:Ben Tre");	    break;
            case 84:	System.out.println("Noi sinh:Tra Vinh");	break;
            case 86:	System.out.println("Noi sinh:Vinh Long");	break;
            case 87:	System.out.println("Noi sinh:Dong Thap");	break;
            case 89:	System.out.println("Noi sinh:An Giang");	break;
            case 91:	System.out.println("Noi sinh:Kien Giang");	break;
            case 92:	System.out.println("Noi sinh:Can Tho");	    break;
            case 93:	System.out.println("Noi sinh:Hau Giang");	break;
            case 94:	System.out.println("Noi sinh:Soc Trang");	break;
            case 95:	System.out.println("Noi sinh:Bac Lieu");	break;
            case 96:	System.out.println("Noi sinh:Ca Mau");	    break;
            default:    System.out.println("loi! sai so ccd");
                inMyNumber();
                break;
        }
        checkInformation();
    }

    public static void ageAndSex(){
        String ageNumber =myNewNumber.substring(4,6);
        int newAgeNumber = Integer.parseInt(ageNumber);

        String sexNumber =myNewNumber.substring(3,4);
        int newSexNumber = Integer.parseInt(sexNumber);

        switch (newSexNumber) {
            case 0:     System.out.println("Gioi tinh: Nam | " + (newAgeNumber + 1900));break;
            case 1:     System.out.println("Gioi tinh: Nu | " + (newAgeNumber + 1900));break;
            case 2:     System.out.println("Gioi tinh: Nam | " + (newAgeNumber + 2000));break;
            case 3:     System.out.println("Gioi tinh: Nu | " + (newAgeNumber + 2100));break;
            case 4:     System.out.println("Gioi tinh: Nam | " + (newAgeNumber + 2200));break;
            case 5:     System.out.println("Gioi tinh: Nu | " + (newAgeNumber + 2300));break;
            case 6:     System.out.println("Gioi tinh: Nam | " + (newAgeNumber + 2400));break;
            case 7:     System.out.println("Gioi tinh: Nu | " + (newAgeNumber + 2500));break;
            case 8:     System.out.println("Gioi tinh: Nam | " + (newAgeNumber + 2600));break;
            case 9:     System.out.println("Gioi tinh: Nu | " + (newAgeNumber + 2700));break;
            default:    System.out.println("loi! vui long nhap lai");
                inMyNumber();
                break;
        }
        checkInformation();
    }

    public static void myRandomNumber(){
        String randomNumber =myNewNumber.substring(6);
        System.out.println(randomNumber);
        checkInformation();

    }



}


