package programs;

import java.util.Scanner;
import java.util.Random;

public class ThrowDie {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("How many times to throw a die?: ");
		int timesToThrow = scanner.nextInt();

		System.out.print("Enter seed: ");
		int seed = scanner.nextInt();

		Random random = new Random(seed);
		int dieNumber;

		for (int i = 0; i < timesToThrow; i++) {
			
			dieNumber = random.nextInt(6) + 1;
			System.out.println("Throw #" + (i + 1));
			
			if (dieNumber == 1) {
				System.out.println("...\n.0.\n...");
			}
			
			if (dieNumber == 2) {
				System.out.println("0..\n...\n..0");
			}
			
			if (dieNumber == 3) {
				System.out.println("0..\n.0.\n..0");
			}
			
			if (dieNumber == 4) {
				System.out.println("0.0\n...\n0.0");
			}
			
			if (dieNumber == 5) {
				System.out.println("0.0\n.0.\n0.0");
			}
			
			if (dieNumber == 6) {
				System.out.println("0.0\n0.0\n0.0");
			}
			
		}
		
		scanner.close();
	}
}
