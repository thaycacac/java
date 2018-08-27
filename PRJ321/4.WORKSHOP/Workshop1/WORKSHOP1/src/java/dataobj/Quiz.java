package dataobj;

import java.sql.Date;

/**
 *
 * @author Thaycacac
 */
public class Quiz {

    private int id;
    private String title;
    private Date createdDate;
    private int ownedBy;

    public Quiz() {
    }

    public Quiz(int id, String title, Date createdDate, int ownedBy) {
        this.id = id;
        this.title = title;
        this.createdDate = createdDate;
        this.ownedBy = ownedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(int ownedBy) {
        this.ownedBy = ownedBy;
    }

}
