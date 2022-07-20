package using;

import data.AssetList;
import data.AssetManagerment;
import data.BorrowList;
import data.Employee;
import data.EmployeeList;
import data.RequestList;
import data.Utils;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Trung.Hoang
 */
public class UsingMain {

    public static void main(String[] args) {
        EmployeeList ep = new EmployeeList();
        Employee em = new Employee();
        AssetManagerment al = new AssetManagerment();
        RequestList rq = new RequestList();
        BorrowList br = new BorrowList();
        AssetList asl = new AssetList();
        int choice;
        int option;

        al.addIntforToFile();
        try {
            do {
                Utils.printMenuLogin();
                choice = Utils.getInt("Enter your choice: ");
                switch (choice) {
                    
                    // FOR MANAGER
                    case 1:
                        option = al.login();
                        if (option == 1) {
                            System.out.println(" --- Login Successful ---\n");
                            int choice2;
                            try {
                                do {
                                    Utils.printMenuForManager();
                                    choice2 = Utils.getInt("Enter your choice: ");
                                    switch (choice2) {
                                        case 1:
                                            //asl.printAssetList();
                                            al.searchAssetByName();
                                            System.out.println("");
                                            break;
                                        case 2:
                                            al.add();
                                            System.out.println("");
                                            break;
                                        case 3:
                                            asl.showAssetList();
                                            al.update();
                                            System.out.println("");
                                            break;
                                        case 4:
                                            al.approveRequest();
                                            System.out.println("");
                                            break;
                                        case 5:
                                            al.printBrrowList();
                                            System.out.println("");
                                            break;
                                        case 6:
                                            choice2 = 6;
                                            break;
                                    }
                                    if (choice2 == 6) {
                                        break;
                                    } else if (choice2 > 6){
                                        choice = 3;
                                    }
                                } while (choice2 >= 1 && choice2 <= 6);
                            } catch (Exception e) {
                            }

                        } else if (option == 2) {
                            System.out.println("You are not the Manager!");
                        } else {
                            System.out.println("Incorrect Employee ID or Paswword!");
                        }
                        System.out.println("");
                        break;

                    // FOR EMPLOYEE
                    case 2:
                        int choice3;
                        option = al.login();
                        if (option == 1 || option == 2) {
                            System.out.println(" ---- Login Successful ----\n");
                            try {
                                do {
                                    Utils.printMenuForEmployee();
                                    choice3 = Utils.getInt("Enter your choice: ");
                                    switch (choice3) {
                                        case 1:
                                            al.searchAssetByName();
                                            System.out.println("");
                                            break;
                                        case 2:
                                            al.borrowTheAssets();
                                            System.out.println("");
                                            break;
                                        case 3:
                                            al.cancelRequest();
                                            System.out.println("");
                                            break;
                                        case 4:
                                            al.returnRequest();
                                            System.out.println("");
                                            break;
                                        case 5:
                                            choice3 = 5;
                                            break;
                                    }
                                    if (choice3 == 5) {
                                        break;
                                    } else if (choice3 > 5){
                                        choice = 3;
                                    }
                                } while (choice3 >= 1 && choice3 <= 5);
                            } catch (Exception e) {
                            }
                        } else {
                            System.out.println("Incorrect Employee ID or Paswword!");
                        }
                        System.out.println("");
                        break;
                }
            } while (choice >= 1 && choice <= 2);
        } catch (Exception e) {
        }
    }
}
