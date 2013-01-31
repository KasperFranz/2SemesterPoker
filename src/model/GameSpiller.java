/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jacob
 */
public class GameSpiller {

    private Spil[] game;
    private Spiller[] spiller;
    private int buyIn;
    private int betThisRound;
    private Card[] kort;

    public GameSpiller(Spiller[] spiller, FiveCardDraw game) {
        game.addPlayer(this.spiller);
        buyIn = 200;
        betThisRound = 20;
    }

//    public void GameSpiller(Spiller[] spiller){
//        
//    }
//    
//    public void GameSpiller(FiveCardDraw game){
//        
//    }
    
    public boolean bet() {
        return true;
    }

    private void checkBalance(int chipKonto) {
        boolean balance;
        balance = true;

    }
}
