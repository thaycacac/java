package Model.Entity;

/**
 *
 * @author minhndse04560
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private String email;
    private int type;

    public User(int id, String userName, String password, String email, int type) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
