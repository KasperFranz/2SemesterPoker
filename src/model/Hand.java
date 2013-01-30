package model;

/**
 *
 * @author NiklasRenner
 */
public class Hand implements Comparable<Hand> {

    private Card[] cards;
    private int[] cardValues;
    private int[] finalRank;
    private int[] sortedRank;
    private int sameRank;
    private int sameRank2;
    private int lowGroupRank;
    private int highGroupRank;
    private int topStraight;
    private boolean straight;
    private boolean flush;

    public Hand(Card[] kort) {

        cards = new Card[5];
        cards = kort;
        cardValues = new int[14];
        finalRank = new int[6];
        sortedRank = new int[5];
        topStraight = 0;
        sameRank = 1;
        sameRank2 = 1;
        lowGroupRank = 0;
        highGroupRank = 0;

        //Sætter alle kort fra hånden ind i et int array på de pladser som tilsvarer kortenes værdi
        for (int i = 0; i < cards.length; i++) {
            cardValues[cards[i].getRank()]++;
        }
        
        straight = isStraight();
        flush = isFlush();

        //Tjekker for ens kort(tæller ned så den tager højeste kort først)
        for (int x = 13; x >= 1; x--) {
            //Hvis der er flere end 1 kort med samme værdi
            if (cardValues[x] > sameRank) {
                //Hvis der er flere end 2 kort med samme værdi og der allerede er fundet 2 ens
                if (sameRank != 1) {
                    sameRank2 = sameRank;
                    lowGroupRank = highGroupRank;
                }
                sameRank = cardValues[x];
                highGroupRank = x;
                //Hvis der allerede er fundet 3 ens og der bliver fundet flere end 1 kort med samme værdi
            } else if (cardValues[x] > sameRank2) {
                sameRank2 = cardValues[x];
                lowGroupRank = x;
            }
        }

        //Sætter es som højeste værdi ved par, 3 ens eller 4 ens
        if (highGroupRank == 1) {
            highGroupRank = 14;
        } else if (lowGroupRank == 1) {
            lowGroupRank = 14;
        }

        int tmp = 0;
        //Tjekker om der 1 es præcist og sætter det ind som det højeste kort, da det normalt har den laveste
        //værdi(1) men er det højeste kort når man sammenligner enkelte kort
        if (cardValues[1] == 1) {
            sortedRank[tmp] = 14;
            tmp++;
        }
        //Sætter resten af de enkelte kort ind i arrayet med esset med højeste kort først
        //Arrayet bruges til at se på højeste kort hvis hænderne ikke har par eller bedre, eller hænderne er ens
        for (int x = 13;
                x >= 2; x--) {
            if (cardValues[x] == 1) {
                sortedRank[tmp] = x;
                tmp++;
            }
        }

        finalRank = getRank();

    }

    public final int[] getRank() {

        int[] ranking = new int[6];

        //Ranking[0] er håndens rank, resten af arrayet er til sammenligning af hænder hvis de har samme rank
        //Nulstiller ranking arrayet
        for (int x = 0; x <= 5; x++) {
            ranking[x] = 0;
        }

        //Hvis der kun er high card sættes rank til 1 
        //og de efterfølgende pladser kortenes værdier med højeste kort først
        if (sameRank == 1) {
            ranking[0] = 1;
            ranking[1] = sortedRank[0];
            ranking[2] = sortedRank[1];
            ranking[3] = sortedRank[2];
            ranking[4] = sortedRank[3];
            ranking[5] = sortedRank[4];
        }

        //Hvis der kun er et par sættes rank til 2
        //Næste plads i arrayet er parrets rank og derefter kommer resten af kortene med højeste kort først
        if (sameRank == 2 && sameRank2 == 1) {
            ranking[0] = 2;
            ranking[1] = highGroupRank;
            ranking[2] = sortedRank[0];
            ranking[3] = sortedRank[1];
            ranking[4] = sortedRank[2];
        }

        //Hvis der er to par sættes rank til 3
        //Derefter sorteres parrene efter værdi og så sættes det resterende kort fra hånden ind til sidst
        if (sameRank == 2 && sameRank2 == 2) {
            ranking[0] = 3;
            ranking[1] = highGroupRank > lowGroupRank ? highGroupRank : lowGroupRank;
            ranking[2] = highGroupRank < lowGroupRank ? highGroupRank : lowGroupRank;
            ranking[3] = sortedRank[0];
        }

        //Hvis der er 3 ens sættes rank til 4
        //Derefter sættes værdien af de 3 ens ind og derefter de resterende kort fra hånden
        if (sameRank == 3 && sameRank2 != 2) {
            ranking[0] = 4;
            ranking[1] = highGroupRank;
            ranking[2] = sortedRank[0];
            ranking[3] = sortedRank[1];
        }

        //Hvis der er straight sættes rank til 5
        //Derefter sættes værdien af det højeste kort i straighten ind
        if (straight && !flush) {
            ranking[0] = 5;
            ranking[1] = topStraight;
        }

        //Hvis der er flush sættes rank til 6
        //Derefter sættes alle kort fra hånden ind med højeste kort først
        if (flush && !straight) {
            ranking[0] = 6;
            ranking[1] = sortedRank[0];
            ranking[2] = sortedRank[1];
            ranking[3] = sortedRank[2];
            ranking[4] = sortedRank[3];
            ranking[5] = sortedRank[4];
        }

        //Hvis der er fuldt hus sættes rank til 7
        //Derefter sættes værdien af de 3 ens ind
        if (sameRank == 3 && sameRank2 == 2) {
            ranking[0] = 7;
            ranking[1] = highGroupRank;
            ranking[2] = lowGroupRank;
        }

        //Hvis der er 4 ens sættes rank til 8
        //Derefter sættes sættes værdien af de 4 ens ind
        if (sameRank == 4) {
            ranking[0] = 8;
            ranking[1] = highGroupRank;
        }

        //Hvis der er straight flush sættes rank til 9
        //Derefter sættes værdien af højeste kort ind
        if (straight && flush) {
            ranking[0] = 9;
            ranking[1] = topStraight;
        }

        //Hvis der er royal flush sættes rank til 10
        if (straight && flush && topStraight == 14) {
            ranking[0] = 10;
        }

        return ranking;
    }

    public final boolean isStraight() {

        //Tjekker for straight
        boolean result = false;
        for (int x = 1; x <= 9; x++) {
            if (cardValues[x] == 1 && cardValues[x + 1] == 1 && cardValues[x + 2] == 1
                    && cardValues[x + 3] == 1 && cardValues[x + 4] == 1) {
                result = true;
                topStraight = x + 4;
                break;
            }
        }

        //Tjekker for straight med es højest
        if (cardValues[10] == 1 && cardValues[11] == 1 && cardValues[12] == 1
                && cardValues[13] == 1 && cardValues[1] == 1) {
            result = true;
            topStraight = 14; //Es sættes til værdi 14 da det er højere end kongen i en straight
        }
        return result;

    }

    public final boolean isFlush() {

        //Tjekker for flush ved at antage at der er en flush indtil den finder 2 kort der ikke matcher
        boolean result = true;
        for (int i = 0; i < cards.length-1; i++) {
            if (cards[i].getSuit() != cards[i + 1].getSuit()) {
                result = false;
            }
        }
        return result;

    }

    @Override
    public int compareTo(Hand hand) {
        for (int x = 0; x < 6; x++) {
            if (this.finalRank[x] > hand.finalRank[x]) {
                return 1;
            } else if (this.finalRank[x] < hand.finalRank[x]) {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        String nameOfHand;
        switch (finalRank[0]) {

            case 1:
                nameOfHand = "High card " + Card.rankAsString(finalRank[1]);
                break;
            case 2:
                nameOfHand = "Par " + Card.rankAsString(finalRank[1]);
                break;
            case 3:
                nameOfHand = "To par: " + Card.multiRankAsString(finalRank[1]) + " og "
                        + Card.multiRankAsString(finalRank[2]);
                break;
            case 4:
                nameOfHand = "3 ens: " + Card.multiRankAsString(finalRank[1]);
                break;
            case 5:
                nameOfHand = "Straight med " + Card.rankAsString(finalRank[1]) + " som højeste kort";
                break;
            case 6:
                nameOfHand = "Flush";
                break;
            case 7:
                nameOfHand = "Fuldt hus: " + Card.multiRankAsString(finalRank[1]) + " over "
                        + Card.multiRankAsString(finalRank[2]);
                break;
            case 8:
                nameOfHand = "4 ens: " + Card.multiRankAsString(finalRank[1]);
                break;
            case 9:
                nameOfHand = "Straight flush med " + Card.rankAsString(finalRank[1]) + " som højeste kort";
                break;
            case 10:
                nameOfHand = "Royal flush!";
                break;
            default:
                nameOfHand = "error in Hand.display: ranking[0] contains invalid ranking";
        }
        return nameOfHand;
    }
}
