/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author Trung.Hoang
 */
public class EmployeeList extends ArrayList<Employee> {

    ArrayList<Employee> list;
    Employee cd;
    int index;

    private static final String NAME_OF_FILE_EMPLOYEE = "employee.dat";

    public EmployeeList() {
        this.list = new ArrayList<>();
        this.cd = null;
        this.index = 0;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String encode(String input) {
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } 
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void addInforToFile() {
        String pw1 = encode("111111");
        list.add(new Employee("E160001", "Nguyen Hong Hiep", "12/06/2000", "EM", "male", pw1));
        String pw2 = encode("222222");
        list.add(new Employee("E160240", "Tran Dinh Khanh", "15/07/2002", "EM", "male", pw2));
        String pw3 = encode("333333");
        list.add(new Employee("E140449", "Le Buu Nhan", "10/07/2002 ", "EM", "male", pw3));
        String pw4 = encode("444444");
        list.add(new Employee("E160798", "Truong Le Minh", "03/12/2002", "EM", "male", pw4));
        String pw5 = encode("888888");
        list.add(new Employee("E160052", "Hoa Doan", "05/06/1990", "MA", "male", pw5));
        writeFileEmploy();
    }

    public int checkLogin(String accountName, String password) {
        readFileEmploy();
        int count = 0;
        for (Employee ep : list) {
            if (ep.getEmployId().equals(accountName) && ep.getPassword().equals(password) && ep.getRole().equalsIgnoreCase("MA")) {
                count = 1;
                break;
            }
            if ((ep.getEmployId().equals(accountName)) && (ep.getPassword().equals(password)) && (ep.getRole().equalsIgnoreCase("EM"))) {
                count = 2;
                break;
            }
        }
        return count;
    }

    public void add() {
        cd = new Employee();
        cd.createEmploy();
        index = list.indexOf(cd);
        if (index == -1) {
            list.add(cd);
            System.out.println("Employee added !");
        } else {
            System.out.println("Duplicate ID!");
        }
        System.out.println("");
    }

    public void printEmployeeList() {
        readFileEmploy();
        for (Employee cl : list) {
            System.out.println("Employee: " + cl.toString());
        }
    }

    public void readFileEmploy() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(NAME_OF_FILE_EMPLOYEE);
            ois = new ObjectInputStream(fis);
            list = (ArrayList<Employee>) ois.readObject();
//            for (Employee vhc : list) {
//                System.out.println(vhc);
//            }
//            System.out.println("\n");
        } catch (FileNotFoundException ex) {
            try {
                File file = new File(NAME_OF_FILE_EMPLOYEE);
                file.createNewFile();
                writeFileEmploy();
            } catch (IOException ex1) {
            }
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    public void writeFileEmploy() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(NAME_OF_FILE_EMPLOYEE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                }
            }
        }
    }

}
