/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Allan
 */
public class Hand implements Comparable {

    public Card[] kort;

    public Hand(Card[] kort) {
        this.kort = kort;
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
