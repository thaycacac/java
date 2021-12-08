
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Comparable<Task> {

    private int ID;
    private String TaskTypeID;
    private String RequirementName;
    private Date Date;
    private double FromPlan;
    private double ToPlan;
    private String Assignee;
    private String Reviewer;
//    private String Expert;

    public Task() {
    }

    public Task(int ID, String TaskTypeID, String RequirementName, Date Date,
            double FromPlan, double ToPlan, String Assignee, String Reviewer) {
        this.ID = ID;
        this.TaskTypeID = TaskTypeID;
        this.RequirementName = RequirementName;
        this.Date = Date;
        this.FromPlan = FromPlan;
        this.ToPlan = ToPlan;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTaskTypeID() {
        return TaskTypeID;
    }

    public void setTaskTypeID(String TaskTypeID) {
        this.TaskTypeID = TaskTypeID;
    }

    public String getRequirementName() {
        return RequirementName;
    }

    public void setRequirementName(String RequirementName) {
        this.RequirementName = RequirementName;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public double getFromPlan() {
        return FromPlan;
    }

    public void setFromPlan(double FromPlan) {
        this.FromPlan = FromPlan;
    }

    public double getToPlan() {
        return ToPlan;
    }

    public void setToPlan(double ToPlan) {
        this.ToPlan = ToPlan;
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }

    public String display(String formatDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
        String dateString = "";

        return String.format("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                ID,
                RequirementName,
                TaskTypeID,
                dateString = sdf.format(Date),
                ToPlan - FromPlan,
                Assignee,
                Reviewer);
    }

    //Toán tử 3 ngôi có thể thay thế dòng 126
    //this.getID() > o.getID() ? -1 : 1
    @Override
    public int compareTo(Task o) {
        return -Integer.compare(this.getID(), o.getID());
    }
}
