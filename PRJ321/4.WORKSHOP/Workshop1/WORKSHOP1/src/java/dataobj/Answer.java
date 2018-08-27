package dataobj;

/**
 *
 * @author Thaycacac
 */
public class Answer {

    private int id;
    private int questionId;
    private String content;
    private boolean isCorrectAnswer;

    public Answer() {
    }

    public Answer(int id, int questionId, String content, boolean isCorrectAnswer) {
        this.id = id;
        this.questionId = questionId;
        this.content = content;
        this.isCorrectAnswer = isCorrectAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isIsCorrectAnswer() {
        return isCorrectAnswer;
    }

    public void setIsCorrectAnswer(boolean isCorrectAnswer) {
        this.isCorrectAnswer = isCorrectAnswer;
    }

}
