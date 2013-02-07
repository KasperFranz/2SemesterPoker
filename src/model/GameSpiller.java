/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jacob
 */
public class GameSpiller implements Comparable<GameSpiller> {

    private FiveCardDraw game;
    private Spiller player;
    private int stack;  // Hedder 'indsats' i klassediagrammet
    private int betThisRound;
    private Card[] cards;

    public GameSpiller(Spiller player, FiveCardDraw game) {
        this.player = player;
        this.game = game;
        this.game.addPlayer(this);
        stack = 200;
        cards = new Card[5];
    }

    //midlertidig til test af BestHand()
    public GameSpiller(Card[] cards) {
       this.cards = cards;
    }

    public void addHand(Card[] hand) {
        this.cards = hand;
    }

    public Card[] getHand() {
        return cards;
    }

    public boolean bet() {
        boolean bet;
        betThisRound = 20;
        if (checkBalance()) {
            stack = stack - getBet();
            game.addToPot(getBet());
            bet = true;
        } else {
            bet = false;
        }
        return bet;
    }

//    Har lavet methoden om til boolean så jeg kan return på om det er true/false. Kunne ikke lige se hvordan det ellers skulle laves
    private boolean checkBalance() {
        boolean check;
        if (getStack() >= getBet()) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

//    Ved ikke om vi får brug for denne metode?
//    public boolean allIn() {
//        boolean allIn;
//        if (getStack() <= getBet()) {
//            allIn = true;
//        } else {
//            allIn = false;
//        }
//        return allIn;
//    }
    public int getBet() {
        return betThisRound;
    }

    public int getStack() {
        return stack;
    }

    public void setBet(int betThisRound) {
        this.betThisRound = betThisRound;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    /**
     * @param Intet
     * @return hand, et hånd objekt
     */
    public Hand bestHand() {
        // laves om når en beskrivelse er der til
        Hand hand;
        if (cards.length == 5) {
            hand = new Hand(cards);
        } else if (cards.length > 5){
            ArrayList<Hand> tmpHandList = new ArrayList<>();
            Card[] tmpCards = new Card[5];
            for (int i = 0; i < cards.length; i++) {
                tmpCards[0] = cards[i];
                for (int j = 1; j < cards.length; j++) {
                    if (j != i) {
                        tmpCards[1] = cards[j];
                        for (int k = 2; k < cards.length; k++) {
                            if (k != j && k != i) {
                                tmpCards[2] = cards[k];
                                for (int l = 3; l < cards.length; l++) {
                                    if (l != k && l != j && l != i) {
                                        tmpCards[3] = cards[l];
                                        for (int m = 4; m < cards.length; m++) {
                                            if (m != l && m != k && m != j && m != i) {
                                                tmpCards[4] = cards[m];
                                                Hand tmpHand = new Hand(tmpCards);
                                                tmpHandList.add(tmpHand);
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }
            Collections.sort(tmpHandList);
            hand = tmpHandList.get(tmpHandList.size()-1);
        } else {
            hand = null;
        }
        return hand;
    }

    /**
     * @param gs af typen GameSpiller
     * @return integer 1, 0 eller -1 i variabel tmp
     */
    @Override
    public int compareTo(GameSpiller gs) {
        int tmp;
        tmp = 0;

        // Vil det her virke??
        tmp = this.bestHand().compareTo(gs.bestHand());

        // Vil det her eller tilsvarende virke??
//        for (int x = 0; x < 6; x++)
//        {
//            if(this.cards[x].getRank() == gs.cards[x].getRank())
//            {
//                tmp = 0;
//                x = 6;
//            }
//            else if(this.bestHand().getRank() > gs.bestHand().getRank())
//            {
//                tmp = 1;
//                x = 6;
//            }
//            else
//            {
//                tmp = -1;
//                x = 6;
//            }
//        }

        return tmp;
    }
}
