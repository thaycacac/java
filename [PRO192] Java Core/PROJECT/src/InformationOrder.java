
public class InformationOrder {

    private String orderId;
    private String customerId;
    private String customerName;
    private String productID;
    private String productName;
    private String address;
    private String date;
    private int quantity;
    private double price;

    public InformationOrder() {
    }

    public InformationOrder(String orderId, String customerId, String customerName, String productID, String productName, String address, String date, int quantity, double price) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.productID = productID;
        this.productName = productName;
        this.address = address;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
