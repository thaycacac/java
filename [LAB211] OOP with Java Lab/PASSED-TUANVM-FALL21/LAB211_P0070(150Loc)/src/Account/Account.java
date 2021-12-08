package Account;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 */
public class Account {
    private String acount;
    private String passwords;

    public Account() {
    }

    public Account(String acount, String passwords) {
        this.acount = acount;
        this.passwords = passwords;
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }
    
    
}
