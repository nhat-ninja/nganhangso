package vn.funix.fx19041.java.asm04.dao;

import vn.funix.fx19041.java.asm02.models.Customer;
import vn.funix.fx19041.java.asm04.service.BinaryFileService;

import java.util.List;

public class CustomerDao {
    public final static String FILE_PATH = "file/customer.dat";
    public static void save(List<Customer> customer) {
        BinaryFileService.writeFile(FILE_PATH,customer);
    }
    public static List<Customer> list(){
        return BinaryFileService.readFile(FILE_PATH);
    }
}
