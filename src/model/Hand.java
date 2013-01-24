/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Allan
 */
public class Hand implements Comparable{
    public Card[] kort;
    public Hand(Card[] kort){
        this.kort = kort;
        
        
    }

    @Override
    public int compareTo(Object o)
    {
        Hand hand = (Hand) o;
        int g;
        if (this.rating == hand.getRating())
        {
            g = 0;
        }
        else if (this.rating > hand.getRating())
        {
            g = 1;
        }
        else
        {
            g = -1;
        }
        return g;
    }
}
