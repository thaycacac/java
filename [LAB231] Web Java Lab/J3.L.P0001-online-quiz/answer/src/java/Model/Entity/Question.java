package Model.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author minhndse04560
 */
public class Question {
    private int id;
    private String content;
    private List<String> option;
    private String answer;
    private Date created;

    public Question(int id, String content, String answer, Date created) {
        this.id = id;
        this.content = content;
        this.answer = answer;
        this.created = created;
        option = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getOption() {
        return option;
    }

    public void addOption(String newOption) {
        this.option.add(newOption);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
