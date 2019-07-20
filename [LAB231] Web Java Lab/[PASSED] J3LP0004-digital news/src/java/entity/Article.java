package entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Thaycacac
 */
public class Article {

    private int id;
    private String title;
    private String image;
    private String content;
    private Date date;
    private String author;
    private String description;

    public Article() {
    }

    public Article(int id, String title, String image, String content, Date date, String author) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.date = date;
        this.author = author;
        if (content.length() <= 100) {
            this.description = content + "...";
        } else {
            this.description = content.substring(0, 100) + "...";
        }
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateFormat() {
        return new SimpleDateFormat("MMMM dd yyy '-' HH:mmaaa").format(this.date).toLowerCase();
    }

}
