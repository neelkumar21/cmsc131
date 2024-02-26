package programs;

import java.util.Scanner;

public class ColorGenerator {

	public static void main(String[] args) {
		/* Write your program here */
		String red;
		String blueGreen;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Do you want red? (Yes/Yeah/No): ");
		
		red = scanner.nextLine();
		
		System.out.print("Do you want green and blue? (Yes/Yeah/No): ");
		
		blueGreen = scanner.nextLine();
		
		if(red.equals("Yes")|| red.equals("Yeah"))
		{
			System.out.print("Final Color: #FF");
		}
		
		else
		{
			System.out.print("Final Color: #00");
		}
		
		if(blueGreen.equals("Yes")|| blueGreen.equals("Yeah"))
		{
			System.out.print("FFFF");
		}
		
		else
		{
			System.out.print("0000");
		}
		
		scanner.close();
		
	}
}