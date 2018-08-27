package dataobj;

import java.util.ArrayList;

/**
 *
 * @author Thaycacac
 */
public class Question {

    private int questionId;
    private String content;
    ArrayList<Answer> listAnswer;

    public Question() {
    }

    public Question(int questionId, String content, ArrayList<Answer> listAnswer) {
        this.questionId = questionId;
        this.content = content;
        this.listAnswer = listAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Answer> getListAnswer() {
        return listAnswer;
    }

    public void setListAnswer(ArrayList<Answer> listAnswer) {
        this.listAnswer = listAnswer;
    }

}
