
public interface IListOrder {

    public boolean checkCustomerID(String id);

    public String generateCustomerID();

    public boolean checkCustomerId(String id);

    public boolean checkOrderId(String id);

    public String getDate();

    public void addOrder(Store p);

    public void printByCustomerId(Store p, String id);

    public void printByOrderId(Store p, String id);

    public void print();
}
