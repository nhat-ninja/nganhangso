package vn.funix.fx19041.java.asm04.dao;

import vn.funix.fx19041.java.asm03.models.Transaction;
import vn.funix.fx19041.java.asm04.service.BinaryFileService;

import java.util.List;

public class TransactionDao {
    public final static String FILE_PATH = "file/transaction.dat";
    public static void save(List<Transaction> transaction) {
        BinaryFileService.writeFile(FILE_PATH,transaction);
    }
    public static List<Transaction> list(){
        return BinaryFileService.readFile(FILE_PATH);
    }
}
