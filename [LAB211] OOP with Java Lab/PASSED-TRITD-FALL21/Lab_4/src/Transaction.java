public class Transaction {

    int value;
    boolean approved;

    public Transaction(int value, boolean approved) {
        this.approved = approved;
        this.value = value;
    }

    public int value() {
        return value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

}