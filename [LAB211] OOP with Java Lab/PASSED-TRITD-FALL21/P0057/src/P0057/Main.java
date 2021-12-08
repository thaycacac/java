 package P0057;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		UserManagementSystem ums = new UserManagementSystem();
		ProcessFile processFile = new ProcessFile();
		Display display = new Display();
		Scanner scanner = new Scanner(System.in);
		

		if (processFile.fileChecker()) {
			// initialize data
			Account acc0 = new Account("NguyenHuuTienAnh", "0123456789@");
			Account acc1 = new Account("NguyenThinh", "NhaCoChoKhong@!@");
			Account acc2 = new Account("Howyoulikethat?", "ThichOanhNhau#");

			// user		password
			display.showTitle(processFile, ProcessFile.getFile());

			ums.addAccount(ProcessFile.getFile(), acc0);
			ums.addAccount(ProcessFile.getFile(), acc1);
			ums.addAccount(ProcessFile.getFile(), acc2);

			display.showOnConsole(ums.getList());

			int choose;
			do {
				display.menu();
				
				choose = scanner.nextInt();
				
				switch (choose) {
				case 1:
					Account acc = ums.createAcc();
					display.showOnConsole(ums.getList());
					break;
				case 2:
					ums.login();
					break;
				case 3:
					System.out.println("Exit!");
					break;
				default:
					System.out.println("\nPlease choose between 1 and 3");
					break;
				}
			} while (choose != 3);
		}
	}
}
