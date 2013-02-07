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
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        Random randomGen = new Random();
        Card tmp;

        // Fylder deck med alle kort i rækkefølge
        for (int a = 1; a <= 4; a++) {
            for (int b = 1; b <= 13; b++) {
                cards.add(new Card(a, b));
            }
        }

        Shuffle();
    }
    
    //Blander kortene
    public void Shuffle(){
        Collections.shuffle(cards);
    }
    
    // Returner det første kort fra bunken og fjerner det samtidig
    public Card drawFromDeck() {
        return cards.remove(0);
    }
    // Tjekker om decket er tomt
    public boolean isEmpty() {
        if(cards.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
