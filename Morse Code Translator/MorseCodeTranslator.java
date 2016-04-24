import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//	***************************
//			Andrew Tam
//		  25 August 2015
//			  v 2.0.2
//	***************************

public class MorseCodeTranslator implements ActionListener, KeyListener{

	// Properties
	public Timer timer;
	public JFrame theframe;
	public JFrame aboutFrame;
	public JPanel thepanel;
	public images aboutPanel;
	public JMenuBar menuBar;
	public JMenu fileMenu;
	public JMenuItem fileMenuItem[] = new JMenuItem[3];
	public boolean blnTranslate = true;
	public JTextArea translateArea;
	public JScrollPane translateScroll;
	public JComboBox directionCB;
	public String[] strDirectionCB = {"Morse to English", "English to Morse"};
	public JButton translateButton;
	public JButton clearButton;
	public JTextArea typeTranslateArea;
	public JScrollPane typeTranslateScroll;
	ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
	
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == timer){
			aboutPanel.repaint();
		}
		if(event.getSource() == fileMenuItem[0]){
			if(blnTranslate == true){
				translateScroll.setVisible(false);
				directionCB.setVisible(false);
				translateButton.setVisible(false);
				typeTranslateScroll.setVisible(true);
				clearButton.setSize(960, 40);
				clearButton.setLocation(20, 550);
				blnTranslate = false;
			}else if(blnTranslate == false){
				typeTranslateScroll.setVisible(false);
				translateScroll.setVisible(true);
				directionCB.setVisible(true);
				translateButton.setVisible(true);
				clearButton.setSize(125,40);
				clearButton.setLocation(850, 150);
				blnTranslate = true;
			}
		}
		//Opens up the About screen when the user clicks on the about button
		if(event.getSource() == fileMenuItem[1]){
			aboutFrame.setVisible(true);
		}
		//Closes the client when the user opts to exit.
		if(event.getSource() == fileMenuItem[2]){
			System.exit(0);	
		}
		if(event.getSource() == translateButton){
			if(directionCB.getSelectedItem() == "Morse to English"){
				translateArea.setText(morseTranslator(translateArea.getText()));
			}
			if(directionCB.getSelectedItem() == "English to Morse"){
				translateArea.setText(englishTranslator(translateArea.getText().toUpperCase()));
			}
		}
		if(event.getSource() == clearButton){
			if(blnTranslate){
				translateArea.setText(null);
			}else{
				typeTranslateArea.setText(null);
			}
		}
	}
	public void keyTyped(KeyEvent event){
		
	}
	public void keyPressed(KeyEvent event){
		
		if(blnTranslate == false){
			typeTranslateArea.append(morseOutput(event));
		}
		
	}
	public void keyReleased(KeyEvent event){
		
	}
	
	 public MorseCodeTranslator(){
		//Setting up the JFrame & JPanel
		theframe = new JFrame("Morse Code Translator v2.0.2 by Andrew Tam");
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setResizable(false);
		theframe.addKeyListener(this);
		theframe.setIconImage(icon.getImage());
		thepanel = new JPanel();
		thepanel.addKeyListener(this);
		thepanel.setPreferredSize(new Dimension(1000,600));
		thepanel.setLayout(null);
		
		//Setting up the aboutFrame & aboutPanel
		aboutFrame = new JFrame("About");
		aboutFrame.setResizable(false);
		aboutFrame.setIconImage(icon.getImage());
		aboutPanel = new images();
		aboutPanel.setPreferredSize(new Dimension(490,490));
		aboutPanel.setLayout(null);
		
		//Setting up the JMenuBar and its items
		fileMenu = new JMenu("File");
		fileMenuItem[0] = new JMenuItem("Switch");
		fileMenuItem[0].addActionListener(this);
		fileMenuItem[1] = new JMenuItem("About");
		fileMenuItem[1].addActionListener(this);
		fileMenuItem[2] = new JMenuItem("Exit");
		fileMenuItem[2].addActionListener(this);
		fileMenu.add(fileMenuItem[0]);
		fileMenu.add(fileMenuItem[1]);
		fileMenu.add(fileMenuItem[2]);;
		menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		theframe.setJMenuBar(menuBar);
		
		//Setting up the translate JTextArea w/ scrollbar
		translateArea = new JTextArea();
		translateScroll = new JScrollPane(translateArea);
        translateScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        translateScroll.setSize(800,500);
        translateScroll.setLocation(20,40);
        thepanel.add(translateScroll);
        translateScroll.setVisible(true);
		
        //Setting up the translate direction JCombobox
		directionCB = new JComboBox(strDirectionCB);
		directionCB.setSize(125,20);
		directionCB.setLocation(850, 40);
		thepanel.add(directionCB);
		directionCB.setVisible(true);
		
		//Setting up the translate JButton
		translateButton = new JButton("Translate");
		translateButton.setSize(125, 40);
		translateButton.setLocation(850, 80);
		translateButton.addActionListener(this);
		thepanel.add(translateButton);
		translateButton.setVisible(true);
		
		//Setting up the clear JButton
		clearButton = new JButton("Clear");
		clearButton.setSize(125,40);
		clearButton.setLocation(850, 150);
		clearButton.addActionListener(this);
		clearButton.addKeyListener(this);
		thepanel.add(clearButton);
		clearButton.setVisible(true);
		
		//Setting up the type-translate JTextArea w/ scroll
		typeTranslateArea = new JTextArea();
		typeTranslateArea.addKeyListener(this);
		typeTranslateArea.setEditable(false);
		typeTranslateScroll = new JScrollPane(typeTranslateArea);
        typeTranslateScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        typeTranslateScroll.setSize(960,500);
        typeTranslateScroll.setLocation(20,40);
        typeTranslateScroll.addKeyListener(this);
        thepanel.add(typeTranslateScroll);
        typeTranslateScroll.setVisible(false);
		
		//Initialization
        timer = new Timer(1000/60, this);
		timer.start();
		theframe.setContentPane(thepanel);
		aboutFrame.setContentPane(aboutPanel);
		theframe.pack();
		aboutFrame.pack();
		theframe.setVisible(true);
		aboutFrame.setVisible(false);
	 }
	 
	 //Function that translates Morse to English
	 private static String morseTranslator(String strWord){
			String[][] strMorse = {{".-", "A"}, {"-...", "B"}, {"-.-.", "C"}, {"-..", "D"}, {".", "E"}, {"..-.", "F"}, {"--.", "G"}, {"....", "H"}, {"..", "I"}, {".---", "J"}, {"-.-", "K"}, {".-..", "L"}, {"--", "M"}, {"-.", "N"}, {"---", "O"}, {".--.", "P"}, {"--.-", "Q"}, {".-.", "R"}, {"...", "S"}, {"-", "T"}, {"..-", "U"}, {"...-", "V"}, {".--", "W"}, {"-..-", "X"}, {"-.--", "Y"}, {"--..", "Z"}};
			String[] strLetters;
			String strOutput = "";
			
			String[] strWords = strWord.split(" / ");
			
			for(int intCount = 0; intCount < strWords.length; intCount++){
				strLetters = strWords[intCount].split(" ");
				for(int intCount2 = 0; intCount2 < strLetters.length; intCount2++){
					for(int intCount3 = 0; intCount3 < 26; intCount3++){
						if(strLetters[intCount2].equalsIgnoreCase(strMorse[intCount3][0])){
							strOutput = strOutput + strMorse[intCount3][1];
						}
					}
				}
				strOutput = strOutput + " ";
			}
			return strOutput;
		}
	 //Function that translates English to Morse
	 private static String englishTranslator(String strWord){
		 String[][] strMorse = {{".-", "A"}, {"-...", "B"}, {"-.-.", "C"}, {"-..", "D"}, {".", "E"}, {"..-.", "F"}, {"--.", "G"}, {"....", "H"}, {"..", "I"}, {".---", "J"}, {"-.-", "K"}, {".-..", "L"}, {"--", "M"}, {"-.", "N"}, {"---", "O"}, {".--.", "P"}, {"--.-", "Q"}, {".-.", "R"}, {"...", "S"}, {"-", "T"}, {"..-", "U"}, {"...-", "V"}, {".--", "W"}, {"-..-", "X"}, {"-.--", "Y"}, {"--..", "Z"}};
		 String[] strLetters;
		 String strOutput = "";
		 
		 String[] strWords = strWord.split(" ");
		 for(int intCount = 0; intCount < strWords.length; intCount++){
			 strLetters = strWords[intCount].split("");
			 for(int intCount2 = 0; intCount2 < strLetters.length; intCount2++){
				 for(int intCount3 = 0; intCount3 < 26; intCount3++){
					 if(strLetters[intCount2].equals(strMorse[intCount3][1])){
						 strOutput = strOutput + strMorse[intCount3][0] + " ";
					 }
				 }
			 }
			 //Only adds a slash if there is more than one word
			 if(strWords.length > 1){
				 strOutput = strOutput + "/ ";
			 }
		 }
		 return strOutput;
	 }
	 //Function that returns the morse letter for the event where a key is typed on the keyboard
	 private static String morseOutput(KeyEvent event){
		 	//If Spacebar is pressed
			if(event.getKeyCode() == 32){
				return("/ ");
			//If "A" is pressed
			}else if(event.getKeyCode() == 65){
				return(".- ");
			//If "B" is pressed
			}else if(event.getKeyCode() == 66){
				return("-... ");
			//If "C" is pressed
			}else if(event.getKeyCode() == 67){
				return("-.-. ");
			//If "D" is pressed
			}else if(event.getKeyCode() == 68){
				return("-..");
			//If "E" is pressed
			}else if(event.getKeyCode() == 69){
				return(". ");
			//If "F" is pressed
			}else if(event.getKeyCode() == 70){
				return("..-. ");
			//If "G" is pressed
			}else if(event.getKeyCode() == 71){
				return("--. ");
			//If "H" is pressed
			}else if(event.getKeyCode() == 72){
				return(".... ");
			//If "I" is pressed
			}else if(event.getKeyCode() == 73){
				return(".. ");
			//If "J" is pressed
			}else if(event.getKeyCode() == 74){
				return(".--- ");
			//If "K" is pressed
			}else if(event.getKeyCode() == 75){
				return("-.- ");
			//If "L" is pressed
			}else if(event.getKeyCode() == 76){
				return("-.-- ");
			//If "M" is pressed
			}else if(event.getKeyCode() == 77){
				return("-- ");
			//If "N" is pressed
			}else if(event.getKeyCode() == 78){
				return("-. ");
			//If "O" is pressed
			}else if(event.getKeyCode() == 79){
				return("--- ");
			//If "P" is pressed
			}else if(event.getKeyCode() == 80){
				return(".--. ");
			//If "Q" is pressed
			}else if(event.getKeyCode() == 81){
				return("--.- ");
			//If "R" is pressed
			}else if(event.getKeyCode() == 82){
				return(".-. ");
			//If "S" is pressed
			}else if(event.getKeyCode() == 83){
				return("... ");
			//If "T" is pressed
			}else if(event.getKeyCode() == 84){
				return("- ");
			//If "U" is pressed
			}else if(event.getKeyCode() == 85){
				return("..- ");
			//If "V" is pressed
			}else if(event.getKeyCode() == 86){
				return("...- ");
			//If "W" is pressed
			}else if(event.getKeyCode() == 87){
				return(".-- ");
			//If "X" is pressed
			}else if(event.getKeyCode() == 88){
				return("-..- ");
			//If "Y" is pressed
			}else if(event.getKeyCode() == 89){
				return("-.-- ");
			//If "Z" is pressed
			}else if(event.getKeyCode() == 90){
				return("--.. ");
			}else{
				return("");
			}
	 }
	 
public static void main(String[] args){
		 MorseCodeTranslator program = new MorseCodeTranslator();
	 }
}
