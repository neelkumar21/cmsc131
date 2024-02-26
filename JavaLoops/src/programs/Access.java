package programs;

import java.util.Scanner;

public class Access {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String passwordGuess;
		int numberGuess = 0;

		for (int i = 0; i < 3; i++) {

			System.out.print("Enter password: ");
			passwordGuess = scanner.next();

			if (passwordGuess.equals("quit")) {
				System.out.println("Access Denied");
				i = 8;
			}

			else {

				System.out.print("Enter number: ");
				numberGuess = scanner.nextInt();

				if (passwordGuess.equals("terps") && numberGuess == 1847) {
					System.out.println("Access Granted");
					i = 8;
				}

				else {
					System.out.println("Wrong credentials");
				}

			}

			if (i == 2) {
				System.out.println("Access Denied");
			}
		}
		scanner.close();

	}
}
