package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import programs.Passport;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {
	/*
	 * Each method in a JUnit StudentTest class represents a test. You can write
	 * code in a method of this class as you do in the main method of a driver. As
	 * you write your code, define methods in this class that test each of the
	 * methods you need to implement. When you run a method you can have
	 * System.out.println statements to see the results of your code. Using this
	 * approach is simpler than defining driver classes.
	 * 
	 * For this project you don't need to worry about adding assertions (we will
	 * talk about them soon). If you don't add assertions, by default, every test
	 * will pass (so when you run your student tests you will see a green bar). We
	 * have left two examples of tests below so you can see how you can test your
	 * code.
	 * 
	 * You can run a single test (e.g., testingtoString() below) by double-clicking
	 * on the method's name and selecting Run-->Run As-->JUnit Test. You can also
	 * double-click on the method's name and select the white triangle that is
	 * inside of a green circle (under Navigate menu entry).
	 */

	@Test
	public void testingtoString() {
		Passport passport1 = new Passport("Rose", "Sanders");
		System.out.println(passport1); // Sanders,Rose

		System.out.println();
	}

	@Test
	public void testingSetSeparator() {
		Passport passport1 = new Passport("Tom", "Johnson");
		System.out.println(passport1); // Johnson,Tom

		passport1.setSeparator('#');
		System.out.println(passport1); // Johnson#Tom

		passport1.setSeparator('@');
		System.out.println(passport1); // Johnson,Tom

		System.out.println();
	}

	@Test
	public void testingGetStamp() {
		Passport passport1 = new Passport("AnseL", "r.", "scHoeNbaum");
		passport1.addStamp("France");
		passport1.addStamp("Korea");
		System.out.println("Stamps for " + passport1 + "-->" + passport1.getStamps());
		// Stamps for Schoenbaum,Ansel,R.-->FranceKorea

		System.out.println();
	}

	@Test
	public void testingEqualsAndCompareTo() {
		Passport passport1 = new Passport("David", "Perez");
		Passport passport2 = new Passport("Nelson", "the GOAT", "Padua-Perez");
		Passport passport3 = new Passport("DAVID", "PeReZ");
		passport3.setSeparator('$');

		// equals
		System.out.println(passport1.equals(passport2)); // false
		System.out.println(passport2.equals(passport3)); // false
		System.out.println(passport3.equals(passport1)); // true

		System.out.println();

		// compareTo
		System.out.println(passport1.compareTo(passport2) > 0); // true
		System.out.println(passport2.compareTo(passport3) < 0); // true
		System.out.println(passport3.compareTo(passport1) == 0); // true

		System.out.println();
	}

	@Test
	public void testingObjectCount() {
		Passport passport1 = new Passport();
		Passport passport2 = new Passport("A", "B");
		Passport passport3 = new Passport("Z", "Y", "X");

		System.out.println(Passport.getNumberOfPassportObjects() == 3); // true
		Passport.resetNumberOfPassportObjects();
		System.out.println(Passport.getNumberOfPassportObjects() == 0); // true

		System.out.println();
	}

	@Test
	public void testingNormalization() {
		Passport passport1 = new Passport("Lindsay", "S.", "Newman");
		Passport passport2 = new Passport("lInDsAY", "S.", "NEwmAn");

		passport2.setSeparator('%');
		System.out.println(Passport.normalize(passport1, true)); // NEWMAN,LINDSAY,S.
		System.out.println(Passport.normalize(passport1, false)); // newman,lindsay,s.
		System.out.println(Passport.normalize(passport2, true)); // NEWMAN%LINDSAY%S.

		System.out.println();
	}

	@Test
	public void testingChangeLastName() {
		Passport passport1 = new Passport("Kim", "Kardashian");
		System.out.println("Original: " + passport1); // Original: Kardashian,Kim
		boolean changed = passport1.changeLastname("West");
		System.out.println(changed); // true
		System.out.println("After marriage: " + passport1); // After marriage: West,Kim
		changed = passport1.changeLastname("");
		System.out.println(changed); // false
		System.out.println(passport1); // West,Kim
		changed = passport1.changeLastname("Kardashian");
		System.out.println(changed); // true
		System.out.println("After divorce: " + passport1); // After divorce: Kardashian,Kim

		System.out.println();
	}
}