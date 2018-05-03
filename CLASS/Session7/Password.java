
public class Password {

    private String password;
    private String role;

    public Password() {
    }

    public Password(String password, String role) {
        this.password = password;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isValidPassword() {
        boolean check = false;
        char[] c = password.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i])) {
                check = true;
                break;
            }
        }
        return check;
    }

    public String getPasswordCode() {
        String s = "";
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i)) == true) {
                s += password.charAt(i);
            }
        }
        return s;
    }
}
