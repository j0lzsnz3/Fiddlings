import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.JPanel;

//***************************
//		Andrew Tam
//	  25 August 2015
//  	 v 2.0.2
//***************************

public class images extends JPanel{
	//Image Files
	BufferedImage about;
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.clearRect(0,0,500,500);
		
		g2d.drawImage(about, 0, 0, null);
	}
	public images(){
		super();
		try {
			about = ImageIO.read(getClass().getResource("aboutscreen.jpg"));
		} catch (IOException e) {
			System.out.println("Error getting images.");
		}
	}
}