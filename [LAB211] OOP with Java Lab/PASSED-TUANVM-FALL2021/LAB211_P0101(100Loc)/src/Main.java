
import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        int choice;
        GetData getData = new GetData();
        EmployeeManagement EmployeeManagement = new EmployeeManagement();
        Display display = new Display();
        ArrayList<Employee> EmployeeList = new ArrayList<>();
        do {
            //1. Display a menu
            display.DisplayMenu();
            //2. Ask and Get user's choice
            choice = getData.getInteger(sc, "Let's select option: ", 1, 6);
            //3.Do the option user select
            switch (choice) {
                case 1://Add Employee
                    EmployeeManagement.addEmployee(EmployeeList);
                    break;
                case 2: //Update employees
                    EmployeeManagement.updateEmployee(EmployeeList);
                    break;
                case 3://Removed employees
                    int Id;
                    EmployeeManagement.removedEmployee(EmployeeList);
                    break;
                case 4: //Search employees
                    EmployeeManagement.Search(EmployeeList);
                    break;
                case 5://Sort employees by salary
                    EmployeeManagement.SortBySalary(EmployeeList);
                    break;
            }
        } while (choice < 6);
    }

}
