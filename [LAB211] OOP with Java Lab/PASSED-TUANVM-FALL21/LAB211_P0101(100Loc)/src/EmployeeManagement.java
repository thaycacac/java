
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 */
public class EmployeeManagement {

    GetData getData = new GetData();
    Scanner sc = new Scanner(System.in);
    Display display = new Display();

    boolean checkIdExist(int Id, ArrayList<Employee> EmployeeList) {
        boolean isExist = false;
        if (EmployeeList.isEmpty()) {
            return isExist;
        } else {
            //loop use to access each element of arraylist from begining to the end
            for (Employee employee : EmployeeList) {
                //Compare Id input and each id of employee has in list
                if (employee.getId() == Id) {
                    System.out.println("Id has been existed!!!");
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }

    void addEmployee(ArrayList<Employee> EmployeeList) {
        int Id;
        if (EmployeeList.isEmpty()) {
            System.out.println("List is Empty!!");
        } else {
            display.DisplayAllList(EmployeeList);
        }
        do {
            Id = getData.getInteger(sc, "Enter employee's id: ", 1, Integer.MAX_VALUE);
            boolean isExist = checkIdExist(Id, EmployeeList);
            //check value of variable isExist
            if (isExist) {
                continue;
            } else {
                break;
            }
        } while (true);
        String FirstName = getData.getString(sc, "Enter employee's first name: ", "");
        String LastName = getData.getString(sc, "Enter employee's last name: ", "");
        //^0: 0 must be is the first digit of phone number
        //[9843]{1}: choose 1 number in [9843]
        //\d{8}: a string need 9 number
        //$: point the end of the line
        String Phone = getData.getString(sc, "Enter employee's phone number: ", "^0[9843]{1}\\d{8}$");
        //^: access position start of line
        //[a-zA-Z0-9]: match all character begin lower case to upercase form a to z and digit in 0 to 9
        //+: check unlimited times imposible
        //@: a string must be have character @
        //\.:match character . 
        //[a-zA-Z]{2,6}:match character in set from 2 to 6 times
        //|: Boolean OR for 2 case email
        //*: check all previous token unlimited times
        //$: point the end of line
        String Email = getData.getString(sc, "Enter employee's email: ",
                "^[a-zA-Z0-9]+@([a-z]{2,6}\\.[a-z]{2,6}|[a-z]{2,6}\\.[a-z]{2,6}\\.[a-z]{2,6})*$");
        String Address = getData.getString(sc, "Enter employee's address: ", "");
        Date DOB;
        do {
            DOB = getData.getDate(sc, "Enter employee birthday[dd/MM/yyyy]: ");
            Date now = new Date();
            if (DOB.before(now)) {
                break;
            } else {
                System.out.println("Birthday must before today!");
                continue;
            }
        } while (true);
        //[FM}: allow input is F or M
        String sex = getData.getString(sc, "Enter employee's gender[F: female; M: male]: ", "[FM]");
        int Salary = getData.getInteger(sc, "Enter employee salary: ", 0, Integer.MAX_VALUE);
        String Agency = getData.getString(sc, "Enter employee agency: ", "");
        Employee employee = new Employee(Id, FirstName, LastName, Phone, Email, Address, DOB, sex, Salary, Agency);
        EmployeeList.add(employee);
    }

    int SearchbyID(ArrayList<Employee> EmployeeList, int id) {
        int pos = -1;
        if (EmployeeList.isEmpty()) {
            System.out.println("List is empty!!!");
        } else {
            //loop use to access each element of arraylist from begining to the end
            for (Employee employee : EmployeeList) {
                //Compare id input and each id of employee has in list
                if (id == employee.getId()) {
                    pos = EmployeeList.indexOf(employee);
                    break;
                }
            }
        }
        return pos;
    }

    void updateEmployee(ArrayList<Employee> EmployeeList) {
        int id;
        int pos;
        do {
            display.DisplayAllList(EmployeeList);
            id = getData.getInteger(sc, "Enter id employee: ", 0, Integer.MAX_VALUE);
            pos = SearchbyID(EmployeeList, id);
            //compare pos with -1
            if (pos == -1) {
                System.out.println("Can't not find employee please enter again!");
                continue;
            } else {
                break;
            }
        } while (true);

        do {
            System.out.println("Choose update option:");
            System.out.println("1: Update first name of employee.");
            System.out.println("2: Update lastname of employee.");
            System.out.println("3: Update phone number of employee.");
            System.out.println("4: Update email of employee.");
            System.out.println("5: Update address of employee.");
            System.out.println("6: Update birthday of employee.");
            System.out.println("7: Udate gender of employee.");
            System.out.println("8: Update salary of employee.");
            System.out.println("9: Update agency of employee.");
            System.out.println("10: Update Id of emloyee.");
            int choice = getData.getInteger(sc, "Let's select option: ", 1, 10);
            switch (choice) {
                case 1:
                    String FirstName = getData.getString(sc, "Enter employee's first name: ", "");
                    EmployeeList.get(pos).setFirstName(FirstName);
                    break;
                case 2:
                    String LastName = getData.getString(sc, "Enter employee's last name: ", "");
                    EmployeeList.get(pos).setLastName(LastName);
                    break;
                case 3:
                    //^0: 0 must be is the first digit of phone number
                    //[9843]{1}: choose 1 number in [9843]
                    //\d{8}: a string need 9 number
                    //$: point the end of the line
                    String Phone = getData.getString(sc, "Enter employee's phone number: ", "^0[9843]{1}\\d{8}$");
                    EmployeeList.get(pos).setPhone(Phone);
                    break;
                case 4:
                    //^: access position start of line
                    //[a-zA-Z0-9]: match all character begin lower case to upercase form a to z and digit in 0 to 9
                    //+: check unlimited times imposible
                    //@: a string must be have character @
                    //\.:match character . 
                    //[a-zA-Z]{2,6}:match character in set from 2 to 6 times
                    //|: Boolean OR for 2 case email
                    //*: check all previous token unlimited times
                    //$: point the end of line
                    String Email = getData.getString(sc, "Enter employee's email: ",
                            "^[a-zA-Z0-9]+@([a-z]{2,6}\\.[a-z]{2,6}|[a-z]{2,6}\\.[a-z]{2,6}\\.[a-z]{2,6})*$");
                    EmployeeList.get(pos).setEmail(Email);
                    break;
                case 5:
                    String Address = getData.getString(sc, "Enter employee's address: ", "");
                    EmployeeList.get(pos).setAddress(Address);
                    break;
                case 6:
                    Date DOB;
                    do {
                        DOB = getData.getDate(sc, "Enter employee birthday[dd/MM/yyyy]: ");
                        Date now = new Date();
                        if (DOB.before(now)) {
                            break;
                        } else {
                            System.out.println("Birthday must before today!");
                            continue;
                        }
                    } while (true);
                    EmployeeList.get(pos).setDOB(DOB);
                    break;
                case 7:
                    //[FM]: accept input is F or M
                    String sex = getData.getString(sc, "Enter employee's gender[F: female; M: male]: ", "[FM]");
                    EmployeeList.get(pos).setSex(sex);
                    break;
                case 8:
                    int Salary = getData.getInteger(sc, "Enter employee salary: ", 0, Integer.MAX_VALUE);
                    EmployeeList.get(pos).setSalary(Salary);
                    break;
                case 9:
                    String Agency = getData.getString(sc, "Enter employee agency: ", "");
                    EmployeeList.get(pos).setAgency(Agency);
                    break;
                case 10:
                    int Id;
                    do {
                        Id = getData.getInteger(sc, "Enter employee's id: ", 1, Integer.MAX_VALUE);
                        boolean isExist = checkIdExist(Id, EmployeeList);
                        //check value of variable isExist
                        if (isExist) {
                            continue;
                        } else {
                            break;
                        }
                    } while (true);
                    EmployeeList.get(pos).setId(Id);
                    break;
            }
            display.DisplayAllList(EmployeeList);
            //[yn]: accept input must be y or n
            String answer = getData.getString(sc, "Do you want to continue?y|n: ", "[yn]");
            //compare value of answer with string "n"
            if (answer.equals("n")) {
                break;
            } else {
                continue;
            }
        } while (true);
    }

    void removedEmployee(ArrayList<Employee> EmployeeList) {
        display.DisplayAllList(EmployeeList);
        int id;
        int pos;
        do {
            id = getData.getInteger(sc, "Enter id employee: ", 0, Integer.MAX_VALUE);
            pos = SearchbyID(EmployeeList, id);
            //compare pos with -1
            if (pos == -1) {
                System.out.println("Can't not find employee please enter again! ");
                continue;
            } else {
                break;
            }
        } while (true);
        EmployeeList.remove(pos);
        display.DisplayAllList(EmployeeList);
    }

    void Search(ArrayList<Employee> EmployeeList) {
        String NameforSearch = getData.getString(sc, "Enter employee name to find: ", "");
        int pos = -1;
        int count = 0;
        System.out.println("Result of Search: ");
        //loop use to access each element of arraylist from begining to the end
        for (int i = 0; i < EmployeeList.size(); i++) {
            String fullname = EmployeeList.get(i).getFirstName() + " " + EmployeeList.get(i).getLastName();
            //check string fullname contains or not input name from user
            if (fullname.contains(NameforSearch)) {
                pos = i;
                //compare variable pos with -1
                if (pos != -1) {
                    count++;
                }
            }
        }

        //check value of variable count
        if (count == 0) {
            System.out.println("Employee doesn't exist");
        } else {
            System.out.format("%3s%10s%10s%15s%30s%20s%12s%5s%10s%10s\n", "Id", "First Name",
                    "Last Name", "Phone Number", "Email", "Address", "Birthday", "Gender", "Salary", "Agency");
        }
        for (int i = 0; i < EmployeeList.size(); i++) {
            String fullname = EmployeeList.get(i).getFirstName() + " " + EmployeeList.get(i).getLastName();
            //check string fullname contains or not input name from user
            if (fullname.contains(NameforSearch)) {
                pos = i;
                //compare variable pos with -1
                if (pos != -1) {
                    display.DisplayElementofList(EmployeeList, pos);
                }
            }
        }
    }

    void SortBySalary(ArrayList<Employee> EmployeeList) {
        Collections.sort(EmployeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //Compare salary of 2 object employee
                if (o1.getSalary() == o2.getSalary()) {
                    return o1.getId() - o2.getId();
                } else {
                    return o1.getSalary() - o2.getSalary();
                }
            }
        });
        display.DisplayAllList(EmployeeList);
    }
}
