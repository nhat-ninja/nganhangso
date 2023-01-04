package vn.funix.fx19041.java.asm04.dao;

import vn.funix.fx19041.java.asm02.models.Account;
import vn.funix.fx19041.java.asm04.service.BinaryFileService;

import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    public final static String FILE_PATH = "file/account.dat";
    public static void save(List<Account> accounts){
        BinaryFileService.writeFile(FILE_PATH,accounts);
    }
    public static List<Account> list(){
        return BinaryFileService.readFile(FILE_PATH);
    }

    public static void update(Account editAccount){
        List<Account> accounts = list();
        boolean hasExist = accounts.stream().anyMatch(account -> account.getAccountNumber().equals(editAccount.getAccountNumber()));
        List<Account> updateAccounts;
        if(!hasExist){
            updateAccounts = new ArrayList<>(accounts);
            updateAccounts.add(editAccount);
        }else{
            updateAccounts = new ArrayList<>();
            for(Account account:accounts){
                if(account.getAccountNumber().equals(editAccount.getAccountNumber())){
                    updateAccounts.add(editAccount);
                }else{
                    updateAccounts.add(account);
                }
            }
        }
        save(updateAccounts);
    }
}
