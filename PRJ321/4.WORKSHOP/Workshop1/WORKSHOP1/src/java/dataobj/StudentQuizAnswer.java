package dataobj;

import java.sql.Date;

/**
 *
 * @author Thaycacac
 */
public class StudentQuizAnswer {

    private int studentId;
    private int quizSessionId;
    private int quizId;
    private int questionId;
    private int answerId;
    private Date createdTime;
    private Date updatedTime;

    public StudentQuizAnswer() {
    }

    public StudentQuizAnswer(int studentId, int quizSessionId, int quizId, int questionId, int answerId, Date createdTime, Date updatedTime) {
        this.studentId = studentId;
        this.quizSessionId = quizSessionId;
        this.quizId = quizId;
        this.questionId = questionId;
        this.answerId = answerId;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getQuizSessionId() {
        return quizSessionId;
    }

    public void setQuizSessionId(int quizSessionId) {
        this.quizSessionId = quizSessionId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

}
