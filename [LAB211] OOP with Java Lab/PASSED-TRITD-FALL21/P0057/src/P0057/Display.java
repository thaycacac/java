package P0057;

import java.io.File;
import java.util.ArrayList;

public class Display {
	final String horizontalLine = " ========== ";

	public void menu() {
		System.out.println();
		System.out.println(horizontalLine + "USER MANAGEMENT SYSTEM" + horizontalLine);
		System.out.print("1. Create a new account\n" + "2. Login system\n" + "3. Exit\n" + "> choose: ");
	}

	public void showTitle(ProcessFile processFile, File file) {
		String tmpS = String.format("%-40s%s\n", "Username", "Password");
		processFile.writeFile(tmpS);
		System.out.print(tmpS);
	}
	
	

	public void showOnConsole(ArrayList<Account> repo) {
		System.out.println();
		String tmpS;
		for (Account acc : repo)
		{
			tmpS = String.format("%-40s%s\n", acc.getusername(), acc.getpassword());
			System.out.print(tmpS);
		}
		
	}
}
