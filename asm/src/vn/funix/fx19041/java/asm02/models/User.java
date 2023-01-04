package vn.funix.fx19041.java.asm02.models;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private String customerId;

    public User(){

    }
    public User(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }
    public static boolean validName(String name){
        boolean checkName = false;
        for (int i = 0; i < name.length(); i++) {
            checkName = name.length() >= 2 && Character.isLetter(name.charAt(i));
        }
        return checkName;
    }


    public void setName(String name) {
        if (validName(name)) {
            this.name = name;
        } else {
            System.out.println("Loi");
        }
    }

    public static boolean validID(String customerId) {
        Map<String, String> province = new HashMap<String, String>();
        province.put("001", "Ha Noi");
        province.put("002", "Ha Giang");
        province.put("004", "Cao Bang");
        province.put("006", "Bac Kan");
        province.put("008", "Tuyen Quang");
        province.put("010", "Lao Cai");
        province.put("011", "Dien Bien");
        province.put("012", "Lai Chau");
        province.put("014", "Son La");
        province.put("015", "Yen Bai");
        province.put("017", "Hoa Binh");
        province.put("019", "Thai Nguyen");
        province.put("020", "Lang Son");
        province.put("022", "Quang Ninh");
        province.put("024", "Bac Giang");
        province.put("025", "Phu Tho");
        province.put("026", "Vinh Phuc");
        province.put("027", "Bac Ninh");
        province.put("030", "Hai Duong");
        province.put("031", "Hai Phong");
        province.put("033", "Hung Yen");
        province.put("034", "Thai Binh");
        province.put("035", "Ha Nam");
        province.put("036", "Nam Dinh");
        province.put("037", "Ninh Binh");
        province.put("038", "Thanh Hoa");
        province.put("040", "Nghe An");
        province.put("042", "Ha Tinh");
        province.put("044", "Quang Binh");
        province.put("045", "Quang Tri");
        province.put("046", "Thua Thien Hue");
        province.put("048", "Da Nang");
        province.put("049", "Quang Nam");
        province.put("051", "Quang Ngai");
        province.put("052", "Binh Dinh");
        province.put("054", "Phu Yen");
        province.put("056", "Khanh Hoa");
        province.put("058", "Ninh Thuan");
        province.put("060", "Binh Thuan");
        province.put("062", "Kon Tum");
        province.put("064", "Gia Lai");
        province.put("066", "Dak Lak");
        province.put("067", "Dak Nong");
        province.put("068", "Lam Dong");
        province.put("070", "Binh Phuoc");
        province.put("072", "Tay Ninh");
        province.put("074", "Binh Duong");
        province.put("075", "Dong Nai");
        province.put("077", "Ba Ria - Vung Tau");
        province.put("079", "Ho Chi Minh");
        province.put("080", "Long An");
        province.put("082", "Tien Giang");
        province.put("083", "Ben Tre");
        province.put("084", "Tra Vinh");
        province.put("086", "Vinh Long");
        province.put("087", "Dong Thap");
        province.put("089", "An Giang");
        province.put("091", "Kien Giang");
        province.put("092", "Can Tho");
        province.put("093", "Hau Giang");
        province.put("094", "Soc Trang");
        province.put("095", "Bac Lieu");
        province.put("096", "Ca Mau");

        //Check length of string and string is number and valid city number
        boolean checkCCCD;
        String numCity = customerId.substring(0,3);
        checkCCCD= customerId.length() == 12 && customerId.matches("\\d+") && !(province.get(numCity) == null);
        return checkCCCD;
    }

    public void setCustomerId(String customerId) {

        if (validID(customerId)) {
            this.customerId = customerId;
        } else {
            System.out.println("Loi");
        }
    }

    public String getCustomerId() {
        return this.customerId;
    }
}
