
import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String address;
    private double salary;

    public Person() {
        // TODO Auto-generated constructor stub
    }

    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Person> getPerson(String path, double money) throws Exception {
        DataBase data = new DataBase();
        data.setDataBase(path);

        List<Person> source = data.getPersonList();
        List<Person> result = new ArrayList<Person>();

        for (Person p : source) {
            if (p.getSalary() >= money) {
                result.add(p);
            }
        }

        return result;
    }
}
