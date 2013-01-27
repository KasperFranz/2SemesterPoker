/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NiklasRenner
 */
import java.util.Random;
import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    Deck() {
        cards = new ArrayList<Card>();
        Random randomGen = new Random();
        Card tmp;

        for (int a = 1; a <= 4; a++) {
            for (int b = 1; b <= 13; b++) {
                cards.add(new Card(a, b));
            }
        }
        
        for (int x = 1; x < cards.size(); x++) {
            int randNum = randomGen.nextInt(cards.size() - 1);
            tmp = cards.get(randNum);
            cards.set(randNum, cards.get(x));
            cards.set(x, tmp);
        }
    }

    public Card drawFromDeck() {
        return cards.remove(0);
    }

    public boolean isEmpty() {
        if(cards.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
