package programs;

import java.util.Scanner;

public class Convert {

	public static void main(String[] args) {
		/* Write your program here */

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter decimal number: ");
		int decimalNumber = scanner.nextInt();
		int octalNumber = 8;
		String answer = "";
		
		if(decimalNumber == 0) {
			answer = "0";
		}

		while (decimalNumber > 0) {
			answer += decimalNumber % octalNumber;
			decimalNumber = decimalNumber / octalNumber;
		}

		System.out.println("Octal value: " + reverseString(answer));
		scanner.close();

	}

	public static String reverseString(String s) {
		String answer = "";

		for (int i = s.length() - 1; i >= 0; i--) {
			answer += s.charAt(i);
		}

		return answer;
	}

}
