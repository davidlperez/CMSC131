package programs;

import java.util.Scanner;

public class Divisible {

	public static void main(String[] args) {
		Scanner calculator = new Scanner(System.in);
		int x, y, remainder;
		
		System.out.print("Enter x: ");
		x = calculator.nextInt();
		
		System.out.print("Enter y: ");
		y = calculator.nextInt();
		
		remainder = x % y;
		System.out.println("Remainder: " + remainder);
		
		if (remainder == 0) {
			System.out.println(x + " is divisible by " + y);
		} else {
			System.out.println(x + " is NOT divisible by " + y);
		}
		
		calculator.close();
	}
}