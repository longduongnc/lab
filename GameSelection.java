import java.util.Scanner;

public class GameSelection {
    public static void main(String[] args) throws InterruptedException {
        BlackJack blackjackgame = new BlackJack();
        HighLowGame highlowgame = new HighLowGame();
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Enter 1 to play the game 0 to exit");
        int play = scnr.nextInt();

        while(play ==1){
            System.out.println("Enter 1 to play Black Jack or 0 for High-Low game.");
            int option = scnr.nextInt();

            if(option==1){
                blackjackgame.playGame();
            } else if (option==0){
                highlowgame.playGame();
            } else {
                System.out.println("please enter valid number.");
                option = scnr.nextInt();
            }

            System.out.println("1 to select another game 0 to exit");
            play = scnr.nextInt();
        }
    }
}
