
public class Worker extends Person {

    private int hrs;
    private final double RATE = 7.5;//hằng số phải viết hoa

    public Worker() {
        super();//contructor of Person class
        hrs = 1;
    }

    public Worker(String name, int hrs) {
        super(name);
        this.hrs = hrs;
    }

    public double getSalary() {
        return hrs * RATE;
    }
    
    //annotation
    @Override
    public void print() {
        super.print();
        System.out.println("Worker saying...");
    }
    

}
