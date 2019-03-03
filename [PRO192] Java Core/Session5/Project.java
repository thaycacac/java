
public class Project implements Comparable<Project> {

    @Override
    public int compareTo(Project o) {
    //    if(this.started > o.started) return -1;
    //    else if(this.started==o.started) return 0;
    //    else return 1;
        return o.started - this.started;// Descending -123
    }

    private String name, sponsor;
    private int started;

    public Project() {
    }

    public Project(int started, String name, String sponsor) {
        this.name = name;
        this.sponsor = sponsor;
        this.started = started;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public int getStarted() {
        return started;
    }

    public void setStarted(int started) {
        this.started = started;
    }

    public void display() {
        System.out.printf("%-20s%-20s%-15d\n", name, sponsor, started);
    }
}
