/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NiklasRenner
 */
public class Card implements Comparable {

    private int rank, suit;
    private static String[] suits = {"Hjerter", "Spar", "Ruder", "Klør"};
    private static String[] ranks = {"Es", "2", "3", "4", "5", "6", "7", "8", "9", "10", "knægt", "dame", "konge"};

    Card(int suit, int rank) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override 
    public int compareTo(Object o) {
        Card card = (Card) o;
        if (this.rank < card.getRank()) {
            return -1;
        } else if (this.rank > card.getRank()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public @Override
    String toString() {
        return suits[suit] + " " + ranks[rank];
    }
}
