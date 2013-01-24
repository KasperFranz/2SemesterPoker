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
       Hand g = new Hand();
       Hand e = new Hand();
       ArrayList<Hand> hands = new ArrayList<>();
       hands.add(e);
        hands.add(g);
        Collections.sort(hands);
       
    }
}
