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
		System.out.println(passport1);
	}

	@Test
	public void testingSetSeparator() {
		Passport passport1 = new Passport("Tom", "Johnson");
		System.out.println(passport1);

		passport1.setSeparator('#');
		System.out.println(passport1);
	}

	@Test
	public void test01Constructor() {
		// full name
		Passport fullName = new Passport("Lionel", "Andres", "Messi");
		// no middle name
		Passport noMiddle = new Passport("Lionel", "", "Messi");

		System.out.println(fullName + "\n" + noMiddle);

	}

	@Test
	public void test02Constructor() {
		Passport firstLast = new Passport("Cristiano", "Ronaldo");
		System.out.println(firstLast);

		Passport defaultPassport = new Passport();
		System.out.println(defaultPassport);

		Passport passport1 = new Passport(defaultPassport);
		System.out.println(passport1);

	}

	@Test
	public void test03Stamps() {
		Passport passport1 = new Passport("Neel", "", "Kumar");
		passport1.addStamp("London");
		System.out.println(passport1.getStamps());
	}

	@Test
	public void test04Separators() {
		Passport passport1 = new Passport("Neymar", "Soccer", "Junior");
		passport1.setSeparator('$');
		System.out.println(passport1.getSeparator());
	}

	@Test
	public void test05Equals() {
		Passport passport1 = new Passport("Albert", "Science", "Einstein");
		Passport passport2 = new Passport("Albert", "Science", "Einstein");
		Passport passport3 = new Passport("Einstein", "Science", "Albert");
		System.out.println(passport1.equals(passport2));
		System.out.println(passport1.equals(passport3));
	}

	@Test
	public void test06CompareTo() {
		Passport passport1 = new Passport("Isaac", "Science", "Newton");
		Passport passport2 = new Passport("Isaac", "Science", "Newton");
		Passport passport3 = new Passport("Albert", "Science", "Einstein");
		System.out.println(passport1.compareTo(passport2));
		System.out.println(passport2.compareTo(passport3));
		System.out.println(passport3.compareTo(passport2));
	}

	@Test
	public void test07numberOfPassports() {
		Passport passport1 = new Passport("Patrick", "Lavon", "Mahomes");
		passport1.resetNumberOfPassportObjects();
		System.out.println(passport1.getNumberOfPassportObjects());
		Passport passport2 = new Passport("Tom", "Football", "Brady");
		System.out.println(passport2.getNumberOfPassportObjects());
	}

	@Test
	public void test08normalize() {
		Passport passport1 = new Passport("Justin", "Patrick", "Herbert");
		System.out.println(passport1.normalize(passport1, true));
		System.out.println(passport1.normalize(passport1, false));
	}

	@Test
	public void test09changeLastName() {
		Passport passport1 = new Passport("Lebron", "Basketball", "James");
		System.out.println(passport1.changeLastname("James"));
	}

}