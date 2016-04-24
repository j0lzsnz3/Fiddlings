import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Andrew Tam
 * 22 June 2015
 * version 1.0
 */

public class Hangman implements ActionListener{
	//Properties
	public Timer timer;	
	public JFrame theframe;
	public JAnimation thepanel;
	public JButton mainButton[] = new JButton[3];
	public JButton playButton[] = new JButton[2];
	public JButton lettersButton[] = new JButton[26];
	public String strWord;
	public hm hang = new hm();
	
	//Methods
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == timer){
			thepanel.repaint();
		}
		//Play Button is pressed
		if(event.getSource() == mainButton[0]){
			thepanel.blnMain = false;
			mainButton[0].setVisible(false);
			mainButton[1].setVisible(false);
			mainButton[2].setVisible(false);
			playButton[0].setVisible(true);
			playButton[1].setVisible(true);
		}
		//Help button is pressed
		if(event.getSource() == mainButton[1]){
			thepanel.blnMain = false;
			mainButton[0].setVisible(false);
			mainButton[1].setVisible(false);
			mainButton[2].setVisible(false);
		}
		//Exit button is pressed
		if(event.getSource() == mainButton[2]){
			System.exit(0);
		}
		//Single Player button is pressed
		if(event.getSource() == playButton[0]){
			playButton[0].setVisible(false);
			playButton[1].setVisible(false);
			for(int intCount2 = 0; intCount2 < 26; intCount2++){
				lettersButton[intCount2].setVisible(true);
			}
			strWord = hang.wordReturner();
			thepanel.strLetters = hang.letterReturner(strWord);
			System.out.println(thepanel.strLetters[0]);
			thepanel.intWordLength = strWord.length();
			thepanel.blnStart = true;
			thepanel.blnSingle = true;
		}
		if(event.getSource() == lettersButton[0]){
			lettersButton[0].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "a");
			thepanel.strLetter = "a";
		}
		if(event.getSource() == lettersButton[1]){
			lettersButton[1].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "b");
			thepanel.strLetter = "b";
		}
		if(event.getSource() == lettersButton[2]){
			lettersButton[2].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "c");
			thepanel.strLetter = "c";
		}
		if(event.getSource() == lettersButton[3]){
			lettersButton[3].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "d");
			thepanel.strLetter = "d";
		}
		if(event.getSource() == lettersButton[4]){
			lettersButton[4].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "e");
			thepanel.strLetter = "e";
		}
		if(event.getSource() == lettersButton[5]){
			lettersButton[5].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "f");
			thepanel.strLetter = "f";
		}
		if(event.getSource() == lettersButton[6]){
			lettersButton[6].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "g");
			thepanel.strLetter = "g";
		}
		if(event.getSource() == lettersButton[7]){
			lettersButton[7].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "h");
			thepanel.strLetter = "h";
		}
		if(event.getSource() == lettersButton[8]){
			lettersButton[8].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "i");
			thepanel.strLetter = "i";
		}
		if(event.getSource() == lettersButton[9]){
			lettersButton[9].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "j");
			thepanel.strLetter = "j";
		}
		if(event.getSource() == lettersButton[10]){
			lettersButton[10].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "k");
			thepanel.strLetter = "k";
		}
		if(event.getSource() == lettersButton[11]){
			lettersButton[11].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "l");
			thepanel.strLetter = "l";
		}
		if(event.getSource() == lettersButton[12]){
			lettersButton[12].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "m");
			thepanel.strLetter = "m";
		}
		if(event.getSource() == lettersButton[13]){
			lettersButton[13].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "n");
			thepanel.strLetter = "n";
		}
		if(event.getSource() == lettersButton[14]){
			lettersButton[14].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "o");
			thepanel.strLetter = "o";
		}
		if(event.getSource() == lettersButton[15]){
			lettersButton[15].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "p");
			thepanel.strLetter = "p";
		}
		if(event.getSource() == lettersButton[16]){
			lettersButton[16].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "q");
			thepanel.strLetter = "q";
		}
		if(event.getSource() == lettersButton[17]){
			lettersButton[17].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "r");
			thepanel.strLetter = "r";
		}
		if(event.getSource() == lettersButton[18]){
			lettersButton[18].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "s");
			thepanel.strLetter = "s";
		}
		if(event.getSource() == lettersButton[19]){
			lettersButton[19].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "t");
			thepanel.strLetter = "t";
		}
		if(event.getSource() == lettersButton[20]){
			lettersButton[20].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "u");
			thepanel.strLetter = "u";
		}
		if(event.getSource() == lettersButton[21]){
			lettersButton[21].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "v");
			thepanel.strLetter = "v";
		}
		if(event.getSource() == lettersButton[22]){
			lettersButton[22].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "w");
			thepanel.strLetter = "w";
		}
		if(event.getSource() == lettersButton[23]){
			lettersButton[23].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "x");
			thepanel.strLetter = "x";
		}
		if(event.getSource() == lettersButton[24]){
			lettersButton[24].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "y");
			thepanel.strLetter = "y";
		}
		if(event.getSource() == lettersButton[25]){
			lettersButton[25].setEnabled(false);
			 
			thepanel.strInput = hang.wordChecker(strWord, "z");
			thepanel.strLetter = "z";
		}
		//Multiplayer button is pressed
		if(event.getSource() == playButton[1]){
			
		}
	}
	//Constructor
	public Hangman(){
		//JFrame & JPanel Initialization
		theframe = new JFrame("Hangman by Andrew Tam");
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setResizable(false);
		thepanel = new JAnimation();
		thepanel.setPreferredSize(new Dimension(600,500));
		thepanel.setLayout(null);
		
		//Play Button
		mainButton[0] = new JButton("Play");
		mainButton[0].setSize(100,50);
		mainButton[0].setLocation(250,325);
		mainButton[0].addActionListener(this);
		thepanel.add(mainButton[0]);
		mainButton[0].setVisible(true);
		
		//Help Button
		mainButton[1] = new JButton("Help");
		mainButton[1].setSize(100,50);
		mainButton[1].setLocation(250,385);
		mainButton[1].addActionListener(this);
		thepanel.add(mainButton[1]);
		mainButton[1].setVisible(true);
		
		//Exit Button
		mainButton[2] = new JButton("Exit");
		mainButton[2].setSize(100,50);
		mainButton[2].setLocation(250,445);
		mainButton[2].addActionListener(this);
		thepanel.add(mainButton[2]);
		mainButton[2].setVisible(true);
		
		//Single Player Button
		playButton[0] = new JButton("Single Player");
		playButton[0].setSize(200,50);
		playButton[0].setLocation(90,385);
		playButton[0].addActionListener(this);
		thepanel.add(playButton[0]);
		playButton[0].setVisible(false);
		
		//Multi-Player Button
		playButton[1] = new JButton("Mutliplayer");
		playButton[1].setSize(200,50);
		playButton[1].setLocation(310,385);
		playButton[1].addActionListener(this);
		thepanel.add(playButton[1]);
		playButton[1].setVisible(false);
		
		//Letter Buttons
		lettersButton[0] = new JButton("A");
		lettersButton[0].setLocation(25,300);
		lettersButton[1] = new JButton("B");
		lettersButton[1].setLocation(80,300);
		lettersButton[2] = new JButton("C");
		lettersButton[2].setLocation(135,300);
		lettersButton[3] = new JButton("D");
		lettersButton[3].setLocation(190,300);
		lettersButton[4] = new JButton("E");
		lettersButton[4].setLocation(245,300);
		lettersButton[5] = new JButton("F");
		lettersButton[5].setLocation(300,300);
		lettersButton[6] = new JButton("G");
		lettersButton[6].setLocation(355,300);
		lettersButton[7] = new JButton("H");
		lettersButton[7].setLocation(410,300);
		lettersButton[8] = new JButton("I");
		lettersButton[8].setLocation(465,300);
		lettersButton[9] = new JButton("J");
		lettersButton[9].setLocation(520,300);
		lettersButton[10] = new JButton("K");
		lettersButton[10].setLocation(25,355);
		lettersButton[11] = new JButton("L");
		lettersButton[11].setLocation(80,355);
		lettersButton[12] = new JButton("M");
		lettersButton[12].setLocation(135,355);
		lettersButton[13] = new JButton("N");
		lettersButton[13].setLocation(190,355);
		lettersButton[14] = new JButton("O");
		lettersButton[14].setLocation(245,355);
		lettersButton[15] = new JButton("P");
		lettersButton[15].setLocation(300,355);
		lettersButton[16] = new JButton("Q");
		lettersButton[16].setLocation(355,355);
		lettersButton[17] = new JButton("R");
		lettersButton[17].setLocation(410,355);
		lettersButton[18] = new JButton("S");
		lettersButton[18].setLocation(25,410);
		lettersButton[19] = new JButton("T");
		lettersButton[19].setLocation(80,410);
		lettersButton[20] = new JButton("U");
		lettersButton[20].setLocation(135,410);
		lettersButton[21] = new JButton("V");
		lettersButton[21].setLocation(190,410);
		lettersButton[22] = new JButton("W");
		lettersButton[22].setLocation(245,410);
		lettersButton[23] = new JButton("X");
		lettersButton[23].setLocation(300,410);
		lettersButton[24] = new JButton("Y");
		lettersButton[24].setLocation(355,410);
		lettersButton[25] = new JButton("Z");
		lettersButton[25].setLocation(410,410);
		
		for(int intCount = 0; intCount < 26; intCount++){
			lettersButton[intCount].setSize(50,50);
			lettersButton[intCount].addActionListener(this);
			thepanel.add(lettersButton[intCount]);
			lettersButton[intCount].setVisible(false);;
		}
		
		//Initialization
		timer = new Timer(1000/60, this);
		timer.start();
		theframe.setContentPane(thepanel);
		theframe.pack();
		theframe.setVisible(true);
	}
	//Main Program
	public static void main(String[] args){
		Hangman program = new Hangman();
	}
}
