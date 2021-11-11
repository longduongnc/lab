import java.util.Scanner;

public class HighLowGame {
    
    public void playGame() {
        
        Deck deck = new Deck();
        Scanner scnr = new Scanner(System.in);

        System.out.println("enter 1 to play 0 to exit");
        int play = scnr.nextInt();
        
        while (play == 1){
            Card card1 = deck.drawCard();
            System.out.println("The first card is " + card1.declareCard());
            System.out.println("Will the next card higher or lower? ");
            System.out.println("Enter 1 for lower, 2 for higher.");

            int choice = scnr.nextInt();

            Card card2 = deck.drawCard();
            boolean higher = card2.getValue(false) > card1.getValue(false);
            if (card1.getValue(false) == card2.getValue(false)){
                System.out.println("Card Value were the same, no winner or loser this round.");
            } else if ((higher && choice ==2)||(!higher && choice ==1)){
                System.out.println("Winner!");
            } else {
                System.out.println("Sorry, your guess was incorrect :(");
            }

            System.out.println("enter 1 to play again, 0 to exit");
            play = scnr.nextInt();
        }

        //scnr.close();
    }
}
