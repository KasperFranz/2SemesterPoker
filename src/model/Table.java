/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jacob
 */
public class Table {

    private Spiller[] spiller;
    private int pot;
    private int bigBlind;
    private int smallBlind;
    private int buyIn;
    private int bet;

    public Table(Spiller[] player) {
        spiller = new Spiller[4];
        spiller = player;
        pot = 0;
        bigBlind = 2;
        smallBlind = bigBlind / 2;
        buyIn = 200;
    }

    private boolean checkBalance(Spiller spiller) {
        boolean balance;
        balance = true;
        if (spiller.getChipKonto() < getBigBlind()) {
            balance = false;
            if (spiller.getChipKonto() < getBet()) {
                balance = false;
            } else {
                balance = true;
            }
        } else {
            balance = true;
        }
        return balance;
    }

    public int getPot() {
        return pot;
    }

    public int getBigBlind() {
        return bigBlind;
    }

    public int getSmallBlind() {
        return smallBlind;
    }

    public int getBuyIn() {
        return buyIn;
    }

    private int getBet() {
        return bet;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public void setBigBlind(int bigBlind) {
        this.bigBlind = bigBlind;
    }

    public void setBuyIn(int buyIn) {
        this.buyIn = buyIn;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
}
