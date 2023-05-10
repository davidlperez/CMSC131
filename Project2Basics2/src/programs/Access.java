package programs;

import java.util.Scanner;

public class Access {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String password, number;

		for (int i = 0; i < 3; i++) {

			System.out.print("Enter password: ");
			password = input.next();

			if (password.equals("quit")) {
				System.out.println("Access Denied");
				break;
			} else {
				System.out.print("Enter number: ");
				number = input.next();
				if (password.equals("terps") && number.equals("1847")) {
					System.out.println("Access Granted");
					break;
				} else if (i == 2) {
					System.out.println("Wrong credentials\nAccess Denied");
				} else {
					System.out.println("Wrong credentials");
				}

			}
		}
		input.close();
	}

}
