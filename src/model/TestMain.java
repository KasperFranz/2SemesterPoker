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
        // Bruges til at starte 4 GUIer
        TestClass testClass = new TestClass();

        Card[] kort = new Card[5];
        kort[0] = new Card(1, 1);
        kort[1] = new Card(1, 10);
        kort[2] = new Card(1, 11);
        kort[3] = new Card(1, 12);
        kort[4] = new Card(1, 13);

        Card[] kort2 = new Card[5];
        kort2[0] = new Card(2, 9);
        kort2[1] = new Card(2, 10);
        kort2[2] = new Card(2, 11);
        kort2[3] = new Card(2, 12);
        kort2[4] = new Card(2, 13);

        Card[] kort3 = new Card[5];
        kort3[0] = new Card(3, 1);
        kort3[1] = new Card(2, 10);
        kort3[2] = new Card(2, 11);
        kort3[3] = new Card(2, 12);
        kort3[4] = new Card(2, 13);

        Card[] kort4 = new Card[5];
        kort4[0] = new Card(2, 9);
        kort4[1] = new Card(2, 5);
        kort4[2] = new Card(2, 11);
        kort4[3] = new Card(2, 12);
        kort4[4] = new Card(4, 13);

        Card[] kort5 = new Card[5];
        kort5[0] = new Card(2, 9);
        kort5[1] = new Card(1, 9);
        kort5[2] = new Card(3, 9);
        kort5[3] = new Card(2, 13);
        kort5[4] = new Card(1, 13);

        Hand hand = new Hand(kort);
        Hand hand2 = new Hand(kort2);
        Hand hand3 = new Hand(kort3);
        Hand hand4 = new Hand(kort4);
        Hand hand5 = new Hand(kort5);

        ArrayList<Hand> hands = new ArrayList<>();
        hands.add(hand);
        hands.add(hand2);
        hands.add(hand3);
        hands.add(hand4);
        hands.add(hand5);

        System.out.println("før sort");
        for (int i = 0; i < hands.size(); i++)
        {
            System.out.println(hands.get(i));

        }
        Collections.sort(hands);
        System.out.println("efter sort");
        for (int i = 0; i < hands.size(); i++)
        {
            System.out.println(hands.get(i));

        }
        /*while (!d.isEmpty()){
         System.out.println(d.drawFromDeck());
         }*/

        //Test af BestHand() i gamespiller
        System.out.println("");
        Deck deck = new Deck();
        Card[] test = new Card[7];
        for (int i = 0; i < test.length; i++)
        {
            test[i] = deck.drawFromDeck();
            System.out.print("" + test[i].toString() + " - ");
        }

        GameSpiller gs = new GameSpiller(test);

        System.out.println("\n" + gs.bestHand());
    }
}
