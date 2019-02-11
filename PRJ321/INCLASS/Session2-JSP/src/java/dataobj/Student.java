package dataobj;

import java.sql.Date;

/**
 *
 * @author Thaycacac
 */
public class Student {

    private int no;
    private String group;
    private String code;
    private String name;
    private String image;
    private String status;
    private String comment;
    private String taker;
    private Date time;

    public Student() {
    }

    public Student(int no, String group, String code, String name, String image, String status, String comment, String taker, Date time) {
        this.no = no;
        this.group = group;
        this.code = code;
        this.name = name;
        this.image = image;
        this.status = status;
        this.comment = comment;
        this.taker = taker;
        this.time = time;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTaker() {
        return taker;
    }

    public void setTaker(String taker) {
        this.taker = taker;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
