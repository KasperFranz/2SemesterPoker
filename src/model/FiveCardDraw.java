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

    private ArrayList<GameSpiller> spillere;
    private GameSpiller dealer;
    private int pulje;
    private Deck deck;

    public FiveCardDraw(GameSpiller dealer) {
        this.dealer = dealer;
        spillere = new ArrayList<>();
        deck = new Deck();
        pulje = 0;
    }
    
    public FiveCardDraw() {
        this.dealer = null;
        spillere = new ArrayList<>();
        deck = new Deck();
        pulje = 0;
    }

    public void startSpil() {
        deck = new Deck();
        for (int i = 0; i < spillere.size(); i++) {
            if(!spillere.get(i).bet()) {
//                Der foldes her
            }
        }
    }

    public void giveCard() {
        for (int i = 0; i < spillere.size(); i++) {
            Card[] cards = new Card[5];
            for (int j = 0; j < cards.length; j++) {
                cards[j] = deck.drawFromDeck();
            }
            spillere.get(i).addHand(cards);
        }
    }

    public void endGame() {
    }

    public void addPlayer(GameSpiller spiller) {
        spillere.add(spiller);
    }

    public void addToPot(int bet) {
        pulje = pulje + bet;
    }
}
