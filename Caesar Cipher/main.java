import java.io.*;

//***************************
//		Andrew Tam
//	  10 August 2015
//		  v 2.0.0
//***************************

public class main {
public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	//Variables
	String strChoice = "";
	String strWord;
	int intChange;
	
	System.out.println("Welcome to the Caesar Cipher! Would you like to encrypt or decrypt?");
	strChoice = br.readLine();
	while(!strChoice.equalsIgnoreCase("encrypt") && !strChoice.equalsIgnoreCase("decrypt")){
		System.out.println("Please input one of the two valid inputs: 'encrypt' or 'decrypt'");
		strChoice = br.readLine();
	}
	
	if(strChoice.equalsIgnoreCase("encrypt")){
		System.out.println("Enter your word to encrypt!");
		strWord = br.readLine();
		System.out.println("How many times do you want to shift the letters?");
		intChange = Integer.parseInt(br.readLine());
		while(intChange <= 0){
			System.out.println("Please input a positive/non-zero Integer!");
			intChange = Integer.parseInt(br.readLine());
		}
		System.out.println("Your encrypted word is: " + CaesarCipher(strWord, intChange));
	}else if(strChoice.equalsIgnoreCase("decrypt")){
		System.out.println("Enter your word to decrypt!");
		strWord = br.readLine();
		System.out.println("How many times were the letters shifted?");
		intChange = Integer.parseInt(br.readLine());
		System.out.println("Your decryped word is: " + CaesarDecoder(strWord, intChange));
	}
}

public static String CaesarCipher(String strWord, int intChange){
	StringBuffer out = new StringBuffer(strWord.length());
	char ca[] = strWord.toCharArray();
	for(char c : ca){
		if(c > 'w'){
			c = (char)(c - 26 - intChange);
		}else if(c < 'd'){
			c = (char)(c + 23 - intChange);
		}else{
			c += intChange;
		}
		out.append(c);
	}
	return out.toString();
}

public static String CaesarDecoder(String strWord, int intChange){
	StringBuffer out = new StringBuffer(strWord.length());
	char ca[] = strWord.toCharArray();
	for(char c: ca){
		if(c > 'w'){
			c = (char)(c - 26 - intChange);
		}else if(c < 'd'){
			c = (char)(c + 26 - intChange);
		}else{
			c -= intChange;
		}
		out.append(c);
	}
	return out.toString();
}