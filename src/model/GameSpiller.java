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

    private FiveCardDraw game;
    private Spiller player;
    private int stack;  // Hedder 'indsats' i klassediagrammet
    private int betThisRound;
    private Card[] hand;

    public void GameSpiller() {
    }

    public GameSpiller(Spiller player, FiveCardDraw game) {
        this.player = player;
        this.game = game;
        this.game.addPlayer(this.player);
        stack = 200;
        hand = new Card[5];
    }
    
    public void addHand(Card[] hand){
        this.hand = hand;
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
        } else {    //            Spilleren skal evt. checke, folde eller gå all-in ?her?
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
    
    public void setBet(int betThisRound){
        this.betThisRound = betThisRound;
    }
    
    public void setStack(int stack){
        this.stack = stack;
    }
}