package J1.S.P0059;

/**
 *
 * @author THAYCACAC
 */
public class Person implements Comparable<Person> {

    private String name;
    private String address;
    private double money;

    public Person() {
    }

    public Person(String name, String address, double money) {
        this.name = name;
        this.address = address;
        this.money = money;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public int compareTo(Person t) {
        return (int) (t.getMoney() - this.getMoney());
    }

}
