package day5;

//Copyright Wintriss Technical Schools 2013
import java.applet.AudioClip;
import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/* A basic version of Aaron's scary maze game
* http://buildsomethingawesome.org/blog/2012/10/27/scary-maze-game/ */

public class ScaryMaze extends JPanel implements Runnable, MouseMotionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage maze;
	final int frameWidth = 800;
	final int frameHeight = 600;

	ScaryMaze() throws Exception {
		//1. make a maze image and drop it into your default package http://pixlr.com/editor/
		
		maze = ImageIO.read(getClass().getResource("Scary Maze Game.jpg"));
		
		//2. set the mouse pointer to the start of your maze using:

		new Robot().mouseMove(70, 100);
		
		//3. add a mouse motion listener using:

		addMouseMotionListener(this);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		int mouseColor = maze.getRGB(mouseX, mouseY);
		//4. print the mouseColor variable to see what color the mouse is touching
System.out.println(mouseColor);
		//5. make a variable to hold the background color. 
int backcolor= -16777216; 
		//6. if the mouse falls off the path (if it is on the background)
		if (mouseColor==backcolor)
		{
			scare();
		}
				// call the scare method
		
		//10. if the mouse is on the end color
		int endcolor= -34466;
		if (mouseColor==endcolor)
		{
			JOptionPane.showMessageDialog(null, "Congratulations! You won the game!");
		}
				// pop up a message to tell them they won
	}

	private void scare() {
		System.out.println("BOO!");
		
	//7. find a scary sound and put it in the "default package" where you put your maze picture. Find a scary sound in the Google Drive Application
		
		
		AudioClip sound = JApplet.newAudioClip(getClass().getResource("Scream.wav"));
		//8. play the scary sound. Hint: type "sound" and then a period.		
		sound.play();
		//9. drop an image into your default package, and use the showScaryImage method to scare your victim!
showScaryImage("Doll.jpg");

	}

	private void showScaryImage(String imageName) {
		try {
			maze = ImageIO.read(getClass().getResource(imageName));
		} catch (Exception e) {
			System.err.println("Couldn't find this image: " + imageName);
		}
		repaint();
	}

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new ScaryMaze());
	}

	@Override
	public void run() {
		JFrame frame = new JFrame("The Scary Maze");
		frame.add(this);
		setPreferredSize(new Dimension(frameWidth, frameHeight));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(maze, 0, 0, null);
	}

	@Override
	public void mouseDragged(MouseEvent e) {


		// TODO Auto-generated method stub

	}

}


