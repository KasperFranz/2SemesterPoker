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
public class FiveCardDraw
{

    public ArrayList<GameSpiller> spillere;
    public GameSpiller dealer;
    public int pulje;
    public Deck deck;

    public FiveCardDraw(GameSpiller dealer)
    {
        this.dealer = dealer;
        spillere = new ArrayList<>();
        deck = new Deck();
        pulje = 0;
    }

    public void startSpil()
    {
        deck = new Deck();
    }

    public void giveCard()
    {
        for (int i = 0; i < spillere.size(); i++)
        {
            Card[] cards = new Card[5];
            for (int j = 0; j < 5; j++)
            {
                cards[j] = deck.drawFromDeck();
            }
            spillere.get(i).addHand(cards);
        }
    }

    public void endGame()
    {
        
    }
    
    public void addPlayer(GameSpiller spiller){
        spillere.add(spiller);
    }

    void addToPot(int bet)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
