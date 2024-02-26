package system;
import javax.swing.JOptionPane;

import gui.*;

/**
 * Sample driver illustrating the displaying and animation of
 * diagrams.
 * 
 * @author cmsc132
 *
 */
public class GraphicalDriverExample {
	public static void main(String[] args) {		
		/* Controls size of squares (cells) */
		int cellDimensions = 15;
		int animationSpeedInMilliSecs = 1000;
		
		/* Initializing display unit */
		GraphicalUtilities.initDisplayUnit("Display", cellDimensions);
		
		/* Swap Example */
		char firstRowChar = 'R', secondRowChar = 'G';
		int columns = 2;
		SwapRows swapRows = new SwapRows(firstRowChar, secondRowChar, columns);
		GraphicalUtilities.displayDiagram(swapRows);

		/* Animating */
		JOptionPane.showMessageDialog(null, "Press OK to start animation");
		GraphicalUtilities.animate(swapRows, animationSpeedInMilliSecs);
		
		System.exit(0);
	}
}
