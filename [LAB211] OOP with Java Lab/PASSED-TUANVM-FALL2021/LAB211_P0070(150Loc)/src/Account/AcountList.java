package Account;


import Account.Account;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 */
public class AcountList {
    public ArrayList database(){
        ArrayList<Account> acountList = new ArrayList<>();
        acountList.add(new Account("0123456789", "123456ab"));
        acountList.add(new Account("8888888888", "abcd1234"));
        acountList.add(new Account("1111111111", "1234abcd"));
        
        return acountList;
    }
}
