package programs;

import java.util.Scanner;

public class Area {

	public static void main(String[] args) {
		Scanner measurement = new Scanner(System.in);
		float base, height, area;
		
		System.out.print("Enter base: ");
		base = measurement.nextFloat();
		
		System.out.print("Enter height: ");
		height = measurement.nextFloat();
		
		area = (base * height) / 2;
		System.out.println("Area is: " + area);
		
		measurement.close();
	}
}