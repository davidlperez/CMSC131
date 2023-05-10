package programs;

import java.util.*;

public class ThrowDie {

	public static void main(String[] args) {
		Scanner die = new Scanner(System.in);
		int times, seed;

		System.out.print("How many times to throw a die?: ");
		times = die.nextInt();

		System.out.print("Enter seed: ");
		seed = die.nextInt();

		Random random = new Random(seed);

		for (int i = 0; i < times; i++) {

			System.out.println("Throw #" + (i + 1));

			int sides = random.nextInt(6);
			sides++;

			if (sides == 1) {
				System.out.println("...\n.0.\n...");
			} else if (sides == 2) {
				System.out.println("0..\n...\n..0");
			} else if (sides == 3) {
				System.out.println("0..\n.0.\n..0");
			} else if (sides == 4) {
				System.out.println("0.0\n...\n0.0");
			} else if (sides == 5) {
				System.out.println("0.0\n.0.\n0.0");
			} else if (sides == 6) {
				System.out.println("0.0\n0.0\n0.0");
			}
		}

		die.close();
	}

}
