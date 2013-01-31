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
    private Card[] card;

    public GameSpiller(Spiller spiller, FiveCardDraw game) {
        game.addPlayer(this.player);
        this.player = spiller;
        this.game = game;
        stack = 200;
    }

    public boolean bet() {
        boolean bet;
        betThisRound = 20;
        if (checkBalance() == true) {
            stack = stack - getBet();
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
        } else {    //            Spilleren skal checke, folde eller gå all-in
            check = false;
        }
        return check;
    }

//    Ved ikke om vi får brug for denne metode?
//    public boolean allIn() {
//        return allIn;
//    }
    public int getBet() {
        return betThisRound;
    }

    public int getStack() {
        return stack;
    }
}
