/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Allan
 */
public class TestMain
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {        
        Deck d = new Deck(); 
        ArrayList<Card> cards = new ArrayList<Card>();
        
        for(int i = 0; i < 5; i++) {
            cards.add(d.drawFromDeck());
        }
        
        Collections.sort(cards);
        
        for(int i = 0; i < cards.size(); i++){
            System.out.println(cards.get(i).toString());
        }
        
        /*while (!d.isEmpty()){
            System.out.println(d.drawFromDeck());
        }*/
        
    }
}
