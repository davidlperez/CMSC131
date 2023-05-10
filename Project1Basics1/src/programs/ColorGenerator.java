package programs;

import java.util.Scanner;

public class ColorGenerator {

	public static void main(String[] args) {
		Scanner color = new Scanner (System.in);
		String red, gb;
		
		System.out.print("Do you want red? (Yes/Yeah/No): ");
		red = color.next();
		
		System.out.print("Do you want green and blue? (Yes/Yeah/No): ");
		gb = color.next();
		
		System.out.print("Final Color: #");
		
		if (red.equalsIgnoreCase("Yes") || red.equalsIgnoreCase("Yeah")) {
			System.out.print("FF");
		}else {
			System.out.print("00");
		}
		
		if (gb.equalsIgnoreCase("Yes") || gb.equalsIgnoreCase("Yeah")) {
			System.out.println("FFFF");
		}else {
			System.out.println("0000");
		}
		
		color.close();
	}
}