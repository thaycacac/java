package entity;

import java.sql.Date;

/**
 *
 * @author Thaycacac
 */
public class Article {

    private int id;
    private int type;
    private String title;
    private String content;
    private String image;
    private Date date;
    private String description;

    public Article() {
    }

    public Article(int id, int type, String title, String content, String image, Date date) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.content = content;
        this.image = image;
        this.date = date;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
