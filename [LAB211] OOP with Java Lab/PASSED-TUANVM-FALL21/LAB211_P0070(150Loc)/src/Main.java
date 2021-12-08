


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        GetData getData = new GetData();
        LoginSystem loginSystem = new LoginSystem();
        do{
            //1. Display Menu
            display.displayMenu();
            //2. Enter choice from user
            int choice = getData.getChoice("Please choice one option:", 1, 3);
            //3. Perform option base on the user choice
            switch(choice){
                case 1:
                    //login with Vietnamese language
                    loginSystem.VietnameseSystem();
                    break;
                case 2:
                    //login with English language
                    loginSystem.EnglishSystem();
                    break;
                case 3:
                    //Exist
                    System.exit(0);
                    break;
            }
        }while(true);
    }
}
