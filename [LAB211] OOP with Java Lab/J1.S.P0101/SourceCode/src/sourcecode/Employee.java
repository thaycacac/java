package sourcecode;

import java.util.Date;

/**
 *
 * @author Thaycacac
 */
public class Employee {

    int id;
    String firstName;
    String lastName;
    String phone;
    String email;
    String address;
    Date dob;
    boolean sex;
    double salary;
    String agency;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String phone, String email, String address, Date dob, boolean sex, double salary, String agency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.sex = sex;
        this.salary = salary;
        this.agency = agency;
    }

}
