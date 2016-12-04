package samples.gui;


import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * GUI Code Sample
 * 
 * Create a simple GUI with an empty top panel, a slider, and a button.
 * Clicking in the top panel prints out the mouse click location.
 * Adjusting the slider changes the color of the top panel.
 * Clicking the button quits the program.
 * 
 * @author timwood@seas.gwu.edu
 * Written 12/5/11
 */
public class GuiSample extends JFrame implements MouseListener {

	// Widgets
	private JButton quitB; // Quit button.
	private JSlider colorSlider; // slider to pick color
	private JPanel drawingArea; // To display the color.

	// Constructor.
	public GuiSample(int width, int height) {
		// Set the title and other frame parameters.
		this.setTitle("GUI Widget and Event Listener Example");
		this.setResizable(true);
		this.setSize(width, height);

		// We'll use a Grid Layout to break the frame into 3 rows
		Container cPane = this.getContentPane();
		cPane.setLayout(new GridLayout(3, 1));
		
		// Use an empty JPanel to display a color
		drawingArea = new JPanel();
		cPane.add(drawingArea);
		// Use a regular class (i.e. this) for the mouse event handler
		drawingArea.addMouseListener(this);

		// Quit button
		quitB = new JButton("Quit");
		// Create a "quit" action listener using an anonymous inner class
		quitB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You clicked the button that says: " + arg0.getActionCommand());
				System.exit(0);
			}
		});
		cPane.add(quitB);

		
		// Create a slider with range 1 to 255
		colorSlider = new JSlider(1, 255);
		colorSlider.setValue(100);
		// set the initial color -- using the same value for red, green, and blue will result in a shade of grey.
		drawingArea.setBackground(new Color(colorSlider.getValue(), colorSlider.getValue(), colorSlider.getValue()));

		// Listener using an inner class
		class ColorChangeListener implements ChangeListener {
			public void stateChanged(ChangeEvent arg0) {
				// set the color of the drawing area
				drawingArea.setBackground(new Color(colorSlider.getValue(), colorSlider.getValue(), colorSlider.getValue()));
			}
		}
		// Sliders use ChangeListeners instead of ActionListeners
		colorSlider.addChangeListener(new ColorChangeListener());
		cPane.add(colorSlider);

		// Show the frame.
		this.setVisible(true);
	}

	public void mouseClicked(MouseEvent arg0) {
		System.out.println("You clicked at: " + arg0.getX() + ", " + arg0.getY());
	}

	// Unused mouse event handlers
	public void mouseEntered(MouseEvent arg0) {  }

	public void mouseExited(MouseEvent arg0) {	}

	public void mousePressed(MouseEvent arg0) {	}

	public void mouseReleased(MouseEvent arg0) {	}

	
	public static void main(String[] argv) {
		GuiSample frame = new GuiSample(450, 300);
	}

	
}