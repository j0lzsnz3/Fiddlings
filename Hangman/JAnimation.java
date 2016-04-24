import java.awt.*;

import javax.swing.*;

import java.io.*;
import java.util.Arrays;
import java.awt.image.*;

import javax.imageio.*;

/**
 * Andrew Tam 22 June 2015 version 1.0
 */

public class JAnimation extends JPanel {
	// Properties
	boolean blnMain = true;
	boolean blnSingle = false;
	boolean blnStart = false;
	boolean blnLetters[];
	int intWordLength;
	int intScore = 0;
	int intWrong = 0;
	String strInput;
	String strLetter;
	String strPass[] = new String[12];
	String strLetters[];
	String strSplit[];

	// Image Files
	BufferedImage main = null;

	// Method
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.clearRect(0, 0, 600, 500);

		if (blnMain == true) {
			g2d.drawImage(main, 0, 0, null);
		}
		if (blnSingle == true) {
			if (blnStart == true) {
				blnLetters = new boolean[intWordLength];
				Arrays.fill(blnLetters, false);
				blnStart = false;
			}
			g2d.setFont(new Font("Arial", Font.PLAIN, 50));

			g2d.clearRect(0, 0, 600, 500);
			if (intWordLength == 6) {
				g2d.fillRect(240, 200, 50, 5);
				g2d.fillRect(295, 200, 50, 5);
				g2d.fillRect(350, 200, 50, 5);
				g2d.fillRect(405, 200, 50, 5);
				g2d.fillRect(460, 200, 50, 5);
				g2d.fillRect(515, 200, 50, 5);

				if (blnLetters[0] == true) {
					g2d.drawString(strLetters[0], 250, 199);
				}
				if (blnLetters[1] == true) {
					g2d.drawString(strLetters[1], 305, 199);
				}
				if (blnLetters[2] == true) {
					g2d.drawString(strLetters[2], 360, 199);
				}
				if (blnLetters[3] == true) {
					g2d.drawString(strLetters[3], 415, 199);
				}
				if (blnLetters[4] == true) {
					g2d.drawString(strLetters[4], 470, 199);
				}
				if (blnLetters[5] == true) {
					g2d.drawString(strLetters[5], 525, 199);
				}

			} else if (intWordLength == 7) {
				g2d.fillRect(240, 200, 45, 5);
				g2d.fillRect(290, 200, 45, 5);
				g2d.fillRect(340, 200, 45, 5);
				g2d.fillRect(390, 200, 45, 5);
				g2d.fillRect(440, 200, 45, 5);
				g2d.fillRect(490, 200, 45, 5);
				g2d.fillRect(540, 200, 45, 5);

				if (blnLetters[0] == true) {
					g2d.drawString(strLetters[0], 255, 199);
				}
				if (blnLetters[1] == true) {
					g2d.drawString(strLetters[1], 300, 199);
				}
				if (blnLetters[2] == true) {
					g2d.drawString(strLetters[2], 350, 199);
				}
				if (blnLetters[3] == true) {
					g2d.drawString(strLetters[3], 405, 199);
				}
				if (blnLetters[4] == true) {
					g2d.drawString(strLetters[4], 455, 199);
				}
				if (blnLetters[5] == true) {
					g2d.drawString(strLetters[5], 500, 199);
				}
				if (blnLetters[6] == true) {
					g2d.drawString(strLetters[6], 550, 199);
				}
			} else if (intWordLength == 8) {
				g2d.fillRect(240, 200, 40, 5);
				g2d.fillRect(285, 200, 40, 5);
				g2d.fillRect(330, 200, 40, 5);
				g2d.fillRect(375, 200, 40, 5);
				g2d.fillRect(420, 200, 40, 5);
				g2d.fillRect(465, 200, 40, 5);
				g2d.fillRect(510, 200, 40, 5);
				g2d.fillRect(555, 200, 40, 5);

				if (blnLetters[0] == true) {
					g2d.drawString(strLetters[0], 250, 199);
				}
				if (blnLetters[1] == true) {
					g2d.drawString(strLetters[1], 295, 199);
				}
				if (blnLetters[2] == true) {
					g2d.drawString(strLetters[2], 340, 199);
				}
				if (blnLetters[3] == true) {
					g2d.drawString(strLetters[3], 385, 199);
				}
				if (blnLetters[4] == true) {
					g2d.drawString(strLetters[4], 430, 199);
				}
				if (blnLetters[5] == true) {
					g2d.drawString(strLetters[5], 475, 199);
				}
				if (blnLetters[6] == true) {
					g2d.drawString(strLetters[6], 520, 199);
				}
				if (blnLetters[7] == true) {
					g2d.drawString(strLetters[7], 565, 199);
				}
			} else if (intWordLength == 9) {
				g2d.fillRect(240, 200, 35, 5);
				g2d.fillRect(280, 200, 35, 5);
				g2d.fillRect(320, 200, 35, 5);
				g2d.fillRect(360, 200, 35, 5);
				g2d.fillRect(400, 200, 35, 5);
				g2d.fillRect(440, 200, 35, 5);
				g2d.fillRect(480, 200, 35, 5);
				g2d.fillRect(520, 200, 35, 5);
				g2d.fillRect(560, 200, 35, 5);

				if (blnLetters[0] == true) {
					g2d.drawString(strLetters[0], 240, 199);
				}
				if (blnLetters[1] == true) {
					g2d.drawString(strLetters[1], 280, 199);
				}
				if (blnLetters[2] == true) {
					g2d.drawString(strLetters[2], 320, 199);
				}
				if (blnLetters[3] == true) {
					g2d.drawString(strLetters[3], 360, 199);
				}
				if (blnLetters[4] == true) {
					g2d.drawString(strLetters[4], 400, 199);
				}
				if (blnLetters[5] == true) {
					g2d.drawString(strLetters[5], 440, 199);
				}
				if (blnLetters[6] == true) {
					g2d.drawString(strLetters[6], 480, 199);
				}
				if (blnLetters[7] == true) {
					g2d.drawString(strLetters[7], 520, 199);
				}
				if (blnLetters[8] == true) {
					g2d.drawString(strLetters[8], 560, 199);
				}
			} else if (intWordLength == 10) {
				g2d.fillRect(240, 200, 30, 5);
				g2d.fillRect(275, 200, 30, 5);
				g2d.fillRect(310, 200, 30, 5);
				g2d.fillRect(345, 200, 30, 5);
				g2d.fillRect(380, 200, 30, 5);
				g2d.fillRect(415, 200, 30, 5);
				g2d.fillRect(450, 200, 30, 5);
				g2d.fillRect(485, 200, 30, 5);
				g2d.fillRect(520, 200, 30, 5);
				g2d.fillRect(555, 200, 30, 5);

				if (blnLetters[0] == true) {
					g2d.drawString(strLetters[0], 240, 199);
				}
				if (blnLetters[1] == true) {
					g2d.drawString(strLetters[1], 275, 199);
				}
				if (blnLetters[2] == true) {
					g2d.drawString(strLetters[2], 310, 199);
				}
				if (blnLetters[3] == true) {
					g2d.drawString(strLetters[3], 345, 199);
				}
				if (blnLetters[4] == true) {
					g2d.drawString(strLetters[4], 380, 199);
				}
				if (blnLetters[5] == true) {
					g2d.drawString(strLetters[5], 415, 199);
				}
				if (blnLetters[6] == true) {
					g2d.drawString(strLetters[6], 450, 199);
				}
				if (blnLetters[7] == true) {
					g2d.drawString(strLetters[7], 485, 199);
				}
				if (blnLetters[8] == true) {
					g2d.drawString(strLetters[8], 520, 199);
				}
				if (blnLetters[9] == true) {
					g2d.drawString(strLetters[9], 555, 199);
				}
			}

			try {
				strSplit = strInput.split(",");
				if (strSplit.length == 0) {
					intWrong++;
				}
				for (int intCount = 0; intCount < strSplit.length; intCount++) {
					blnLetters[Integer.parseInt(strSplit[intCount])] = true;
					intScore++;
				}
			} catch (NullPointerException | ArrayIndexOutOfBoundsException
					| NumberFormatException e) {
				// System.out.println("strSplit is empty.");
			}
		}
		if (intWrong == 6) {
			
		} else if (intScore == intWordLength) {

		}
	}

	// Constructor
	public JAnimation() {
		super();
		try {
			main = ImageIO.read(getClass().getResource("main.jpg"));
		} catch (IOException e) {
			System.out.println("Error getting images.");
		}
	}
}
