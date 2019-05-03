
public class Main {

    public static void main(String[] args) {
        Worker w = new Worker("Choi", 70);
        w.print();
        System.out.println("Name = " + w.getName());
        System.out.println("Salary = " + w.getSalary());

        Person p = new Person("Bat");
        //p.getSalary() - không gọi được
        p.print();

        Person p = new Person();
        p.print();
        p = new Worker();
        p.print();
        // The same
        Worker w=new Worker();
        p = w;
        //w = (Worker)p
        w.print();//worker
    }
}
