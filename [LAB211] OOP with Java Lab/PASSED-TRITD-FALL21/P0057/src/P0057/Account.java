package P0057;

import java.util.Scanner;

public class Account {
	private String username;
	private String password;
	Scanner sc = new Scanner(System.in);
	
	public Account(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	
	public boolean equals(Account acc) {
		if (this.getusername().equals(acc.getusername()))
			if (this.getpassword().equals(acc.getpassword()))
				return true;
		return false;
	}
}
