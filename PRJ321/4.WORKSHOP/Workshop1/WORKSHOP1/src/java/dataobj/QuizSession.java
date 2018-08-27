package dataobj;

import java.sql.Date;

/**
 *
 * @author Thaycacac
 */
public class QuizSession {

    private int id;
    private String code;
    private int quizId;
    private int startedBy;
    private Date startedDate;
    private Date endDate;
    private boolean isInProgress;

    public QuizSession() {
    }

    public QuizSession(int id, String code, int quizId, int startedBy, Date startedDate, Date endDate, boolean isInProgress) {
        this.id = id;
        this.code = code;
        this.quizId = quizId;
        this.startedBy = startedBy;
        this.startedDate = startedDate;
        this.endDate = endDate;
        this.isInProgress = isInProgress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getStartedBy() {
        return startedBy;
    }

    public void setStartedBy(int startedBy) {
        this.startedBy = startedBy;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isIsInProgress() {
        return isInProgress;
    }

    public void setIsInProgress(boolean isInProgress) {
        this.isInProgress = isInProgress;
    }

}
