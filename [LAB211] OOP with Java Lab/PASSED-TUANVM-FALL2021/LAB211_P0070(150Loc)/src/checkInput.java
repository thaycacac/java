/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Account.*;
import java.util.ArrayList;

/**
 *
 */
class checkInput {
    boolean checkAccount(String AccountNumber){
        AcountList listAcount = new AcountList();
        ArrayList<Account> accountList = listAcount.database();
        if(accountList.isEmpty()){
            return false;
        }else{
            //loop use to access each element of arraylist from begining to the end
            for (Account account : accountList) {
                //check accountNumber is exist in list acount or not
                if(account.getAcount().equals(AccountNumber)){
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean checkPassword(String AccountNumber, String password){
        AcountList listAcount = new AcountList();
        ArrayList<Account> accountList = listAcount.database();
        if(accountList.isEmpty()){
            return false;
        }else{
            //loop use to access each element of arraylist from begining to the end
            for (Account account : accountList) {
                //check AccountNumber is exist or not in list and 
                //password of AccountNumber input is equal with password of acount 
                //have number account same with AccountNumber or not
                if(account.getAcount().equals(AccountNumber) && account.getPasswords().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }
}
