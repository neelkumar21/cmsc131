package app;

public class DrawingApp {

	public static String getTwoRowsDiagram(char firstRowChar, char secondRowChar, int columns) {
		String answer = "";

		/* First row */
		for (int i = 0; i < columns; i++) {
			answer += firstRowChar;
		}
		answer += "\n";

		/* Second row */
		for (int i = 0; i < columns; i++) {
			answer += secondRowChar;
		}

		return answer;
	}
}