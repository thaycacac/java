import java.util.ArrayList;
import java.util.List;

class Client {

    private String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client name = " + name;
    }
}

public class Account {

    private Client c;
    private List<Transaction> list = new ArrayList<Transaction>();

    public Account(Client c) {
        this.c = c;
    }

    public void add(Transaction t) {
        list.add(t);
    }

    public boolean process(Transaction t) {
        return t.isApproved();
    }

    public Client getCustomer() {
        return c;
    }

    public List<Transaction> getList() {
        return list;
    }
}