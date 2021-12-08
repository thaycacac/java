package P0057;

import java.io.File;
import java.io.FileWriter;

public class ProcessFile {
	private static FileWriter fw;
	private static File file = new File("D:\\FPT University\\FALL 2021\\LAB211\\P0057\\user.dat");

	public static void writeFile(Account acc) {
		try {
			fw = new FileWriter(file, true);
			String tmpS = String.format("%-40s%s\n", acc.getusername(), acc.getpassword());
			fw.write(tmpS);
			fw.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void writeFile(String s) {
		try {
			fw = new FileWriter(file);
			fw.write(s);
			fw.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	// Checking existing of user.dat file before inserting a new account
	public boolean fileChecker() {
		if (file.exists()) {
			System.out.println("user.txt file existed");
			return true;
		} else {
			System.out.println("user.txt file not found!");
			return false;
		}
	}
	
	public static File getFile() {
		return file;
	}
}
