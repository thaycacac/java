
public class Person {

    private String name;

    public Person() {
        name = "";
    }

    public Person(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("Person saying...");
    }

    public String getName() {
        return name;
    }
    
}
