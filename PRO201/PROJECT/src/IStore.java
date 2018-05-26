public interface IStore {
    public void addProduct(Product p);
    public boolean checkProductId(String id);
    public String generateProductID();
    public void updatePrice(String productId, double newPrice);
    public void sortByPrice();
    public void print();
    public String getProductName(String productId);
    public double getProductPrice(String productId);
}
