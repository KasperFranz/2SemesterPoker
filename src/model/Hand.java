/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Allan
 */
public class Hand implements Comparable<Hand> {

    public ArrayList<Card> cards;

    public Hand(Card[] kort) {
        cards = new ArrayList<>();
        cards.addAll(Arrays.asList(kort));
        Collections.sort(cards);
    }

    public int getRank() {
        int rank;
        if (cards.get(0).getRank() == 1 && cards.get(1).getRank() == 10 && cards.get(2).getRank() == 11
                && cards.get(3).getRank() == 12 && cards.get(4).getRank() == 13 && isSameColor()) {
            rank = 1;
        } else if ((cards.get(0).getRank() == cards.get(1).getRank() - 1
                || (cards.get(0).getRank() == 1 && cards.get(4).getRank() == 13))
                && cards.get(1).getRank() == cards.get(2).getRank() - 1
                && cards.get(2).getRank() == cards.get(3).getRank() - 1
                && cards.get(3).getRank() == cards.get(4).getRank() - 1) {
            if (isSameColor()) {
                rank = 2;
            } else {
                rank = 6;
            }
        } else if (isSameRank(4)) {
            rank = 3;
        } else if (isFullHouse()) {
            rank = 4;
        } else if (isSameColor()) {
            rank = 5;
        } else if (isSameRank(3)) {
            rank = 7;
        } else if (isTwoPair()) {
            rank = 8;
        } else if (isSameRank(2)) {
            rank = 9;
        } else {
            rank = 10;
        }



        return rank;
    }

    @Override
    public int compareTo(Hand hand) {
        int result;
        result = 0;
        if (this.getRank() < hand.getRank()) {
            result =  -1;
        } else if (this.getRank() > hand.getRank()) {
            result =  1;
        } else {
            result =  0;
        }
        return result;
    }

    private boolean isSameColor() {
        boolean result;
        result = true;
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i - 1).getSuit() != cards.get(i).getSuit()) {
                result = false;
            }
        }
        return result;
    }

    private boolean isSameRank(int i) {
        
        boolean result = false;
        
        int[] same = new int[14];
        for (int j = 0; j < cards.size(); j++) {
            same[cards.get(j).getRank()]++;
        }
        for (int j = 0; j < same.length; j++) {
            if (same[j] == i){
                result = true;
            }
        }
        return result;              
    }
    
    private boolean isFullHouse() {
        boolean result;
        result = false;
        if (cards.get(0).getRank() == cards.get(1).getRank()
                && (cards.get(1).getRank() == cards.get(2).getRank()
                || cards.get(2).getRank() == cards.get(3).getRank())
                && cards.get(3).getRank() == cards.get(4).getRank()) {
            result = true;
        }
        return result;
    }

    private boolean isTwoPair() {
        boolean result;
        result = false;
        if (cards.get(0).getRank() == cards.get(1).getRank()) {
            if (cards.get(2).getRank() == cards.get(3).getRank()
                    || cards.get(3).getRank() == cards.get(4).getRank()) {
                result = true;
            }
        } else if (cards.get(1).getRank() == cards.get(2).getRank()) {
            if (cards.get(3).getRank() == cards.get(4).getRank()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Hand{rank:"+ getRank()+ " cards=" + cards + '}';
    }
}
