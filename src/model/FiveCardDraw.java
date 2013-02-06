/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;

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

    /** 
     * endGame()
     * Bruges til at se hvilken/hvilke spiller(e) der har vundet og fordeler 
     * indsatsen mellem vinderne
     * @param intet
     * @return intet
     */
    public void endGame() {
        ArrayList<GameSpiller> winners = new ArrayList<>();
        ArrayList<GameSpiller> players = spillere;
        Collections.sort(players);
        for (int i = 0; i < players.size(); i++)
        {
            if(players.get(i).bestHand() == players.get(0).bestHand()){
                winners.add(players.get(i));
            }
        }
    }

    public void addPlayer(GameSpiller spiller) {
        spillere.add(spiller);
    }

    public void addToPot(int bet) {
        pulje = pulje + bet;
    }


}
