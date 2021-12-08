
import Account.AcountList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 */
class LoginSystem {

    void VietnameseSystem() {
        Locale Vietnam = new Locale("vi", "VN");
        loginSystem(Vietnam);
    }

    void EnglishSystem() {
        Locale America = new Locale("en", "US");
        loginSystem(America);
    }
    
    private void loginSystem(Locale locale){
        
        checkInput checkInput = new checkInput();
        GetData getData = new GetData();
        ResourceBundle handleLanguage = ResourceBundle.getBundle("language", locale);
        handleCapcha handle = new handleCapcha();
        
        String account = getData.getAcountNumber(handleLanguage.getString("accountNumber"), 
                handleLanguage.getString("inputAcountError"));
        String password = getData.getPassword(handleLanguage.getString("Password"), 
                handleLanguage.getString("inputPasswordError"));
        handle.handleCapcha(handleLanguage.getString("Capcha"), handleLanguage.getString("CapchaError"), 
                handleLanguage.getString("inputCapcha"));
        
        boolean checkAcount = checkInput.checkAccount(account);
        boolean checkPassword = checkInput.checkPassword(account, password);
        //check value of checkAcount and checkPassword is true or false
        //checkAcount true when Acount have on list acount
        //checkPassword true when Acount and pasword match in list acount
        if(checkAcount && checkPassword){
            System.out.println(handleLanguage.getString("loginSuccess"));
        }else{
            System.out.println(handleLanguage.getString("loginFail"));
        }
    }
}
