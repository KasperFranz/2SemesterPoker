/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author NiklasRenner
 */
public class FiveCardDraw {

    public ArrayList<Spiller> spillere;
    public GameSpiller dealer;
    public int pulje;
    public Deck deck;

    public FiveCardDraw(GameSpiller dealer, ArrayList<Spiller> spillere) {
        this.dealer = dealer;
        this.spillere = spillere;
        deck = new Deck();
        pulje = 0;
    }

    public void startSpil() {
        deck = new Deck();
    }

    public void giveCard() {
        for (int i = 0; i < spillere.size(); i++) {
            Card[] cards = new Card[5];
            for (int j = 0; j < 5; j++) {
                cards[j] = deck.drawFromDeck();
            }
            spillere.addHand(cards);
        }
    }

    public void endGame() {
    }
}
