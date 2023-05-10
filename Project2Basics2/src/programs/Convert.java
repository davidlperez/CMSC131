package programs;

import java.util.Scanner;

public class Convert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int dec, rem;
		String answer = "";

		System.out.print("Enter decimal number: ");
		dec = input.nextInt();

		while (dec >= 0) {
			rem = dec % 8;
			answer = answer + rem;
			dec = dec / 8;
			if (dec == 0) {
				break;
			}

		}
		answer = Support.reverseString(answer);
		System.out.println("Octal value: " + answer);
		input.close();
	}

}
