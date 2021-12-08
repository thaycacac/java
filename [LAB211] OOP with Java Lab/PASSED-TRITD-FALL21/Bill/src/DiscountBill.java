
public class DiscountBill extends GroceryBill {
    private int discountCount;
    private double discount;
    private boolean preferred;

    public DiscountBill(Employee clerk, boolean preferred) {
        super(clerk);
        this.preferred = preferred;
        discountCount = 0;
        discount = 0.0;
    }
    
    public void add(Item i) {
        super.add(i);
        if (preferred && i.getDiscount() > 0) {
            discountCount++;
            discount += i.getDiscount();
        }
    }
    
    public int getDiscountCount() {
        return discountCount;
    }
    
    public double getDiscountAmount() {
        return discount;
    }
    
    public double getTotal() {
        return super.getTotal() - discount;
    }
    
    public double getDiscountPercent() {
        return discount * 100 / super.getTotal();
    }
}
