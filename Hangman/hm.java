import java.io.*;

/**
 * Andrew Tam
 * 22 June 2015
 * version 1.0
 */

public class hm {
	//Finds out how many words are in the Words text file
	public int fileCounter(){
		BufferedReader infile = null;
		int intCount = 0;
		
		try{
			infile = new BufferedReader(new FileReader("Words.txt"));
			while(infile.readLine() != null){
				intCount++;
			}
			infile.close();
		}catch(IOException e){
			System.out.println("Error opening/reading/closing file, filecounter.");
		}
		
		return intCount;
	}
	
	//Gives back a random word from the Words text file
	public String wordReturner(){
		BufferedReader infile = null;
		String strTextList[] = new String[fileCounter()];
		
		try{
			infile = new BufferedReader(new FileReader("Words.txt"));
			for(int intCount = 0; intCount < fileCounter(); intCount++){
				strTextList[intCount] = infile.readLine();
			}
			infile.close();
		}catch(IOException e){
			System.out.println("Error opening/reading/closing file.");
		}
		
		int intRandom = (int)(Math.random() * fileCounter());
		while(strTextList[intRandom].length() > 10 && strTextList[intRandom].length() < 6){
			intRandom = (int)(Math.random() * fileCounter());
		}
		System.out.println(strTextList[intRandom]);
		return strTextList[intRandom];
	}
	//Converts a word into a 1-D array of all its letters **NOT SURE IF NEEDED**
	public String[] letterReturner(String strInput){
		int intLength = strInput.length();
		String strWord[] = new String[intLength];
		
		for(int intCount = 0; intCount < intLength; intCount++){
			strWord[intCount] = strInput.substring(intCount, intCount + 1);
		}
		return strWord;
	}
	//Checks if the guess was correct and which position it was in
	public String wordChecker(String strWord, String strLetter){
		String strReturn = "";
		for(int intCount = 0; intCount < strWord.length(); intCount++){
			if(strLetter.equalsIgnoreCase(strWord.substring(intCount, intCount + 1))){
				if(intCount != (strWord.length() - 1)){ 
				strReturn = strReturn + intCount + ",";
				}else{
					strReturn = strReturn + intCount;
				}
			}
		}
		return strReturn;
	}
}
