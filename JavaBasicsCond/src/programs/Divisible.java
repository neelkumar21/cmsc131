package programs;
import java.util.Scanner;

public class Divisible {

	public static void main(String[] args) {
		/* Write your program here */
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter x: ");
		int x = scanner.nextInt();
		
		System.out.print("Enter y: ");
		int y = scanner.nextInt();
		
		int remainder = x%y;
		System.out.println("Remainder: " + remainder);
		
		if(remainder != 0) 
		{
			System.out.println(x + " is NOT divisible by " + y);
		}
		
		else
		{
			System.out.println(x + " is divisible by " + y);
		}
		
		scanner.close();
	}
}