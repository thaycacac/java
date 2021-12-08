package P0057;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManagementSystem {
	private ArrayList<Account> repo = new ArrayList<Account>();
	private ProcessString ps = new ProcessString();
	private Scanner scanner = new Scanner(System.in);

	public ArrayList<Account> getList() {
		return repo;
	}

	public void addAccount(File file, Account acc) {
		// Adding a user account into user.dat file
		ProcessFile.writeFile(acc);
		// Loading user account from user.dat into Collection
		repo.add(acc);
	}

	// Search user name and password into Collection
	public void find(Account acc) {
		for (Account tmpAcc : repo)
			if (tmpAcc.equals(acc)) {
				System.out.println("Login successfully");
				return;
			}
		System.out.println("Invalid user name or password");
	}

	public boolean find(String username) {
		for (Account tmpAcc : repo)
			if (username.equals(tmpAcc.getusername())) {
				return true;
			}
		return false;
	}

	public Account createAcc() {
		Account account = new Account(inputUsername(), inputPassword());
		addAccount(ProcessFile.getFile(), account);
		return account;
	}

	public void login() {
		String username = "";
		boolean re_enter = false;
		do {
			if (re_enter)
				System.out.println("You must enter least at 5 characters and no spaces");
			System.out.print("Enter Username: ");
			username = scanner.nextLine();
			re_enter = true;
		} while (!ps.userName_Validation(username));
		Account acc = new Account(username, inputPassword());
		find(acc);
	}

	public String inputUsername() {
		String username = "";
		boolean re_enter = false;
		boolean sameAccount = false;

		do {
			if (sameAccount)
				System.err.println("username is existed!");
				System.err.println("Please enter again!");
			do {
				if (re_enter)
					System.out.println("You must enter least at 5 characters and no spaces");
				System.out.print("Enter Username: ");
				username = scanner.nextLine();
				re_enter = true;
			} while (!ps.userName_Validation(username));

			re_enter = false;
			sameAccount = true;
		} while (find(username));
		return username;
	}

	public String inputPassword() {
		String password = "";
		boolean re_enter = false;

		do {
			if (re_enter)
				System.out.println("You must enter least at 8 characters and no spaces, including special characters");
			System.out.print("Enter Password: ");
			password = scanner.nextLine();
			re_enter = true;
		} while (!ps.password_Validation(password));

		return password;
	}

}