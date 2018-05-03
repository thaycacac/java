
public class MyException extends Exception {

    String message;

    public MyException() {
    }

    public MyException(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }

}
