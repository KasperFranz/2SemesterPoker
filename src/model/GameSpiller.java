/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Allan
 */
public class GameSpiller
{
    FiveCardDraw spil;
    Spiller spiller;
    int indsats;
    int betThisRound;
    Card[] kort;
    
    public GameSpiller(Spiller spiller, FiveCardDraw bordet)
    {
        
        this.spil = bordet;
        this.spiller = spiller;
    }
    
    public void bet()
    {
        
    }
    
    public boolean checkBalance()
    {
        
        return true;
    }
    
    
}
