package dataobj;

/**
 *
 * @author Thaycacac
 */
public class User {

    private String user;
    private String pass;
    private int role;

    public User() {
    }

    public User(String user, String pass, int role) {
        this.user = user;
        this.pass = pass;
        this.role = role;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
