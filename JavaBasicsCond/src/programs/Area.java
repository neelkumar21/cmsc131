//I worked with Nicolas Lin
package programs;
import java.util.Scanner;

public class Area {

	public static void main(String[] args) {
		/* Write your program here */
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter base: ");
		int base = scanner.nextInt();
		
		System.out.print("Enter height: ");
		int height = scanner.nextInt();
		
		double area = (double)base*height/2;
		System.out.println("Area is: " + area);
		
		scanner.close();
	}
}
