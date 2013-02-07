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
    public int turn; // 0 = 1. bet runde | 1 = bytte kort | 2 = 2. bet runde ?
    public int activePlayer;
    public ArrayList<GameSpiller> activePlayers;

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
            if (!spillere.get(i).bet()) {
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
        turn = 0; // 1. bet runde begynder?
    }

    /**
     * endGame() Bruges til at se hvilken/hvilke spiller(e) der har vundet og
     * fordeler indsatsen mellem vinderne
     *
     * @param intet
     * @return intet
     */
    public void endGame() {
        ArrayList<GameSpiller> winners = new ArrayList<>();
        ArrayList<GameSpiller> players = spillere;
        Collections.sort(players);
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).bestHand() == players.get(0).bestHand()) {
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

    public int getTurn() {
        return turn;
    }

    public int getActivePlayer() {
        return activePlayer;
    }

    public boolean myTurn(GameSpiller spiller) {
        boolean isTurn;
        isTurn = false;
        if (spiller == activePlayers.get(getActivePlayer())) {
            isTurn = true;
        }
        return isTurn;
    }

    public boolean bet(GameSpiller amount) {
        boolean bet;
        bet = false;
        if (myTurn(amount)) {
            addToPot(amount.getBet());
            bet = true;
            activePlayer++; // næste spiller
            if (activePlayer == 3) {
                activePlayer = 0; // Reset spiller tur
            }
        }
        return bet;
    }

    public void fold(GameSpiller spiller) {
        if (myTurn(spiller)) {
            for (int i = 0; i < activePlayers.size(); i++) {
                if (spiller == activePlayers.get(i)) {
                    activePlayers.remove(spiller);
                }
            }
            activePlayer++; // næste spiller
            if (activePlayer == 3) {
                activePlayer = 0; // Reset spiller tur
                
            }
        }

    }
}
