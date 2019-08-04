package Model.Entity;

/**
 *
 * @author minhndse04560
 */
public class QuizHistory {
    private int id;
    private String studentName;
    private int numOfQuiz;
    private int correctAnswer;

    public QuizHistory(int id, String studentName, int numOfQuiz, int correctAnswer) {
        this.id = id;
        this.studentName = studentName;
        this.numOfQuiz = numOfQuiz;
        this.correctAnswer = correctAnswer;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getNumOfQuiz() {
        return numOfQuiz;
    }

    public void setNumOfQuiz(int numOfQuiz) {
        this.numOfQuiz = numOfQuiz;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
