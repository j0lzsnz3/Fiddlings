import java.util.*;

//*************************
//       Andrew Tam
//    21 September 2015
//         v 1.0
//*************************

public class BinaryTranslator {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		//Variables
		boolean blnContinue = true;
		boolean blnFirstChoice;
		int intInput;
		String strChoice = "";
		String strInput;
		
		System.out.println("Welcome to the Binary Translator written by Andrew Tam!");
		
		//Ensures that the user chooses a valid option.
		while(!strChoice.equalsIgnoreCase("A") && !strChoice.equalsIgnoreCase("B")){
			System.out.println("Would you like to use (A) Binary --> Number or (B) Number --> Binary?");
			strChoice = in.nextLine();
			if(!strChoice.equalsIgnoreCase("A") && !strChoice.equalsIgnoreCase("B")){
				System.out.println("Please enter a valid option");
			}
		}
		
		//Keeps running until the user opts to quit.
		while(blnContinue){
			System.out.println("Key in 'switch' to switch modes or 'quit' to exit the program");
			
			//Binary to Number Mode
			if(strChoice.equalsIgnoreCase("A")){
				strInput = in.nextLine();
				
				//Checks to see if user wants to switch modes or exit.
				if(strInput.equalsIgnoreCase("switch")){
					System.out.println("Switching to Number to Binary mode");
					strChoice = "B";
				}else if(strInput.equalsIgnoreCase("quit")){
					blnContinue = false;
				}
				
				//Needs to use a try/catch to allow the user to use the switch/quit command without causing a NumberFormatException
				try{
					intInput = Integer.parseInt(strInput);
					System.out.println("The binary number " + strInput + " as a regular number is: " +  Integer.parseInt(strInput, 2));
				}catch(NumberFormatException e){
				}
				
			//Number to Binary Mode
			}else if(strChoice.equalsIgnoreCase("B")){
				strInput = in.nextLine();
				
				//Checks to see if user wants to switch modes or exit.
				if(strInput.equalsIgnoreCase("switch")){
					System.out.println("Switching to Binary to Number mode.");
					strChoice = "A";
				}else if(strInput.equalsIgnoreCase("quit")){
					blnContinue = false;
				}
				
				//Needs to use a try/catch to allow the user to use the switch/quit command without causing a NumberFormatException
				try{
				intInput = Integer.parseInt(strInput);
				System.out.println("The number " + strInput + " in binary is: " +  Integer.toBinaryString(intInput));
				}catch(NumberFormatException e){
				}
			}
		}
		//Exit Message
		System.out.println("Thanks for using Binary Translator by Andrew Tam!");
		System.out.println("To see all of my projects, check out my github at 'github.com/ahndrewtam' or visit my website at 'ahndrewtam.me'.");
	}
}
