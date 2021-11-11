import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) throws InterruptedException {
        Deck deck = new Deck();
        Scanner scnr = new Scanner(System.in);

        System.out.println("enter 1 to play 0 to exit");
        int play = scnr.nextInt();

        while(play == 1){

            int houseTotal = deck.drawCard().getValue(true) + deck.drawCard().getValue(true);
            int playerTotal = deck.drawCard().getValue(true) + deck.drawCard().getValue(true);

            System.out.println("The House is showing: "+houseTotal);
            Thread.sleep(500);

            while(playerTotal < 22){
                System.out.println("Player total is: "+playerTotal);
                Thread.sleep(500);
                System.out.println("Would you like to hit or stand? \n\tEnter 1 for hit 0 for stand");
                Thread.sleep(500);
                
                int choice = scnr.nextInt();

                if (choice == 0 ){
                    break;
                } else if (choice ==1){
                    Card nextCard = deck.drawCard();

                    System.out.println("The player has been dealt the " + nextCard.declareCard());
                    playerTotal += nextCard.getValue(true);

                }else{
                    System.out.println("Invalid option, try again.");
                }
                Thread.sleep(500);
            }

            if (playerTotal >21){
                System.out.println("the player has busted! you lose :(");
            } else {
                System.out.println("The player stand with "+playerTotal);
                Thread.sleep(500);
                System.out.println("The house will play next.\nThe house has " +houseTotal);
                Thread.sleep(500);

                while (houseTotal <17){
                    System.out.println("The house take another card");
                    Card nextCard = deck.drawCard();
                    Thread.sleep(500);

                    System.out.println("The house has been dealt the " + nextCard.declareCard());
                    houseTotal += nextCard.getValue(true);

                    if (houseTotal<17){
                        System.out.println("The House keep drawing ");
                        Thread.sleep(500);
                        continue;
                    } else if (houseTotal>17 &&houseTotal<22){
                        System.out.println("The House sits with "+houseTotal);
                        Thread.sleep(500);
                    }
                }

                if (playerTotal > houseTotal | houseTotal >21){
                    System.out.println("Player win! :)");
                } else if(playerTotal == houseTotal){
                    System.out.println("It's a draw!"); 
                } else {
                    System.out.println("The Hosue win! Sorry:(");
                }
                
            }

            Thread.sleep(500);
            System.out.println("enter 1 to play again, 0 to exit");
            play = scnr.nextInt();
        }
        scnr.close();
    }
}
