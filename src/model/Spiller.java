package model;

/**
 *
 * @author Mathias
 */
public class Spiller {

    private int kontonr;
    private int chipKonto;
    private Card[] hand;

    public Spiller(int kontonr) {
        this.kontonr = kontonr;
        chipKonto = 0;
    }
    
    public void addHand(Card[] hand){
        this.hand = hand;
    }
    
    public Card[] getHand(){
        return hand;
    }

    public int getKontonr() {
        return kontonr;
    }

    public int getChipKonto() {
        return chipKonto;
    }

    public void setKontonr(int kontonr) {
        this.kontonr = kontonr;
    }

    public void setChipKonto(int chipKonto) {
        this.chipKonto = chipKonto;
    }

    @Override
    public String toString() {
        return "Spiller{" + "kontonr = " + kontonr + ", chipKonto = " + chipKonto + '}';
    }
}
