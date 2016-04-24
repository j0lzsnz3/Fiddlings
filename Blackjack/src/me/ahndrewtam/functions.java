package me.ahndrewtam;

import java.util.*;

public class functions {
    public static ArrayList newDeck(){
        ArrayList Deck = new ArrayList<String>();

        for(int i = 1; i <= 13; i++){
            Deck.add(i + "ofDiamond");
        }

        for(int i = 1; i <= 13; i++){
            Deck.add(i + "ofClub");
        }

        for(int i = 1; i <= 13; i++){
            Deck.add(i + "ofHeart");
        }

        for(int i = 1; i <= 13; i++){
            Deck.add(i + "ofSpade");
        }

        return Deck;
    }

    public static ArrayList shuffleDeck(ArrayList Deck){
        ArrayList newDeck = new ArrayList<String>();
        int intRandom;

        for(int intCount = Deck.size(); intCount > 0; intCount--){
            intRandom = (int)(Math.random()*intCount);
            newDeck.add(Deck.get(intRandom));
            Deck.remove(intRandom);
        }

        return newDeck;
    }

    public static ArrayList takeOne(ArrayList Deck, ArrayList playerHand){
        playerHand.add(Deck.get(0));
        return playerHand;
    }

    public static ArrayList takeTwo(ArrayList Deck, ArrayList playerHand){
        playerHand.add(Deck.get(0));
        playerHand.add(Deck.get(1));
        return playerHand;
    }

    public static ArrayList removeFirst(ArrayList Deck, int intRemove){
        for(int intCount = 0; intCount < intRemove; intCount++)
            Deck.remove(0);
        return Deck;
    }

    public static String currentHand(ArrayList playerHand){
        String strReturn = "";

        for(int intCount = 0; intCount < playerHand.size(); intCount++){
            if(intCount != 0) {
                strReturn = strReturn + " | " + playerHand.get(intCount);
            }else{
                strReturn = strReturn + playerHand.get(intCount);
            }
        }

        return strReturn;
    }

    public static int handSum(ArrayList playerHand){
        int intSum = 0;
        String strParts[];
        for(int intCount = 0; intCount < playerHand.size(); intCount++){
            strParts = ((String)playerHand.get(intCount)).split("of");
            intSum = intSum + Integer.parseInt(strParts[0]);
        }

        return intSum;
    }

    public static String optimalCard(ArrayList<String> Deck, int sum, int n){
        int newSum;
        int cardValue;
        int smallestCardValue = Integer.MAX_VALUE;
        String smallestCard = "null";
        ArrayList<String> peekedCards = new ArrayList<String>();

        // Adds the first n cards to another list
        for(int i = 0; i < n; i++)
            peekedCards.add(Deck.get(i));

        // Attempts to find a card that makes the sum 21, if not, it returns the smallest card value that does not go
        // over 21. If the smallest makes it go over 21, it returns an empty string
        for(String s : peekedCards){
            cardValue = Integer.parseInt(s.split("of")[0]);
            newSum = sum + cardValue;
            if(newSum == 21) {
                return s;
            }else if(cardValue < smallestCardValue && newSum < 21) {
                smallestCardValue = cardValue;
                smallestCard = s;
            }
        }
        return smallestCard;
    }
}