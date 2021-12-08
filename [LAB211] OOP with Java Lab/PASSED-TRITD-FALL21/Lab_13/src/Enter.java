import java.util.Scanner;

public class Enter {
	Scanner scanner = new Scanner(System.in);

	public String path(String title) {
		System.out.print("Enter " +  title + ": ");
		String path = scanner.next();
		return path;
	}
	
	public String choose() {
		return scanner.next();
	}
	
	public Double money() {
		System.out.print("Enter Salary: ");
		Double money = 0.0;
		try {
			money = Double.parseDouble(scanner.next());
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Can not convert String to Double");
		}
		return money;
	}
}