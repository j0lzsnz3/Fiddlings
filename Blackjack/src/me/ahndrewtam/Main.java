package me.ahndrewtam;
import java.util.*;
import me.ahndrewtam.functions;

//
//************************
//      Andrew Tam
//    (ahndrewtam.me)
//      BlackJack
//       v. 0.1
//************************
//

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        //Variables
        Boolean blnFold = false;
        Boolean blnBust = false;
        Boolean blnNewRun = true;
        String strChoice;
        Double dblCash = 0.0;
        Double dblBet = 0.0;
        ArrayList<String> Deck = new ArrayList<String>();
        ArrayList<String> playerHand = new ArrayList<String>();
        ArrayList<String> opponentHand = new ArrayList<String>();

        // Initializes the game and waits for user to choose a valid mode
        do {
            System.out.println("Welcome to BlackJack! Please select which mode you would like to play!");
            System.out.println("(E)asy; (M)edium (H)ard");
            strChoice = in.nextLine();
        } while(!strChoice.equalsIgnoreCase("E") && !strChoice.equalsIgnoreCase("M") && !strChoice.equalsIgnoreCase("H"));

        // Informs the user what mode they have chosen and how much money they start off with.
        if(strChoice.equalsIgnoreCase("E")){
            dblCash = 1000.0;
            System.out.println("Welcome to Easy! You start with: $" + dblCash + ".");
        }else if(strChoice.equalsIgnoreCase("M")){
            dblCash = 750.0;
            System.out.println("Welcome to Medium! You start with: $" + dblCash + ".");
        }else if(strChoice.equalsIgnoreCase("H")){
            dblCash = 500.0;
            System.out.println("Welcome to Hard! You start with: $" + dblCash + ".");
        }

        while(dblCash > 0.0){
            blnFold = false;
            playerHand.clear();
            opponentHand.clear();
            strChoice = "";
            Deck = functions.shuffleDeck(functions.newDeck());
            playerHand = functions.takeTwo(Deck, playerHand);
            Deck = functions.removeFirst(Deck, 2);
            opponentHand = functions.takeTwo(Deck, opponentHand);
            Deck = functions.removeFirst(Deck, 2);

            System.out.println("--------------------------------------");
            System.out.println("Current Balance: $" + dblCash + ".");
            System.out.println("How much would you like to bet?");

            while (!in.hasNextDouble()){
                System.out.println("Invalid input");
                in.next();
            }

            dblBet = in.nextDouble();
            dblCash = dblCash - dblBet;

            while(blnBust == false && blnFold == false){
                System.out.println("--------------------------------------");
                System.out.println("Your current hand is: " + functions.currentHand(playerHand));
                System.out.println("Your opponent's top card is: " + opponentHand.get(0));
                System.out.println("Hit or fold?");
                while (!strChoice.equalsIgnoreCase("hit") && !strChoice.equalsIgnoreCase("fold")){
                    strChoice = in.nextLine();
                }

                // If the user hits, they get a card and if they fold, they can no longer get another card
                if(strChoice.equalsIgnoreCase("hit")){
                    strChoice = "";
                    System.out.println("You drew: " + Deck.get(0));
                    playerHand = functions.takeOne(Deck, playerHand);
                    Deck = functions.removeFirst(Deck, 1);
                }else if(strChoice.equalsIgnoreCase("fold")){
                    blnFold = true;
                }

                // Should player's hand sum go over 21, they bust
                if(functions.handSum(playerHand) > 21) {
                    System.out.println("Your current hand is: " + functions.currentHand(playerHand));
                    System.out.println("Bust! The sum of the cards in your hand is " + functions.handSum(playerHand));
                    break;
                }else if(functions.handSum(playerHand) == 21){
                    System.out.println("Your current hand is: " + functions.currentHand(playerHand));
                    System.out.println("Nice, you hit 21!");
                    dblCash += dblBet*1.2;
                    break;
                }


                // Adds in the optimal card for the opponent
                if(!(functions.optimalCard(Deck, functions.handSum(opponentHand), 3)).equals("null")){
                    System.out.println("Your opponent drew a card");
                    opponentHand.add(functions.optimalCard(Deck, functions.handSum(opponentHand), 3));
                    Deck.remove(functions.optimalCard(Deck, functions.handSum(opponentHand), 3));
                }else{
                    System.out.println("Your opponent folds");
                }

                if(functions.handSum(opponentHand) > 21) {
                    System.out.println("Ouch, your opponent busted!");
                    dblCash += dblBet*1.2;
                    break;
                }else if(functions.handSum(opponentHand) == 21){
                    System.out.println("Dang, your opponent hit 21!");
                    break;
                }
            }
        }
    }
}