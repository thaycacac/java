
public class FilteredAccount extends Account {

    private int totalAproved = 0;
    private int filtered = 0;

    public FilteredAccount(Client c) {
        super(c);
    }

    @Override
    public boolean process(Transaction t) {
        if (t.isApproved()) {
            totalAproved++;
            if (t.getValue() > 0) {
                return super.process(t);
            } else {
                filtered++;
                return super.process(t);
            }
        } else {
            return super.process(t);
        }
    }

    public double percentFiltered() {
        System.out.println("Filtered approved out: " + filtered);
        System.out.println("Total approved: " + totalAproved);
        if (filtered==0) return 0.0;
        return filtered * 100.0 / totalAproved;
    }

}