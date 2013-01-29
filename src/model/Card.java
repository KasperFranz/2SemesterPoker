/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NiklasRenner
 */
public class Card implements Comparable<Card>{

    private int rank, suit;
    private static String[] suits = {"placeholder", "Hjerter", "Spar", "Ruder", "Klør"};
    private static String[] ranks = {"placeholder", "Es", "2", "3", "4", "5", "6", "7", "8", "9", "10", "knægt", "dame", "konge"};
    private static String[] multiRanks = {"placeholder", "Esser", "2'ere", "3'ere", "4'ere", "5'ere", "6'ere", "7'ere", "8'ere", "9'ere", "10'ere", "knægte", "damer", "konger"};

    public Card(int suit, int rank) {
        this.rank = rank;
        this.suit = suit;
    }   
    // Sammenligning af kort
    @Override 
    public int compareTo(Card c) {
        Card card = c;
        int sort;
    
        if (this.rank < card.getRank()) {
            sort = -1;
        } else if (this.rank > card.getRank()) {
            sort = 1;
        } else {
            sort = 0;
        }
        return sort;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }
    
    public static String multiRankAsString(int value) {
        return multiRanks[value];
    }
    
    public static String rankAsString(int value) {
        return ranks[value];
    }
    
    // Returner hele kortet som string, f.eks. "Hjerter konge"
    public @Override
    String toString() {
        return suits[suit] + " " + ranks[rank];
    }
}
