package src;

import static java.lang.System.exit;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameDriver {
   private final static Logger logger = LogManager.getLogger(GameDriver.class);
   private Scanner sc = new Scanner(System.in);

   private Deck deck;
   private float bet;
   private float balance;
   private String playerName;
   private Player dealer;
   private Player player;
   private boolean playerDone;
   private boolean dealerDone;
   private boolean doubleDownAllowed;

   private GameDriver(String playerName) throws Exception {

      this.balance = 100.0F;
      this.playerName = playerName;
      this.deck = new Deck();
      boolean gameOver = false;
      this.player = new Player(this.playerName);
      this.dealer = new Player("Dealer");

      while (this.balance > 0 && !gameOver) {
         System.out.println("\n" + this.playerName + ", Do you want to DEAL or END the game [D or E]??");
         String gameInit = sc.next();
         if (gameInit.compareToIgnoreCase("D") == 0) {
            this.play();
         } else {
            gameOver = true;
         }
      }
      System.out.println("\n" + this.playerName + ", !!!! Game Ended !!!");

      System.out.println("\n" + this.playerName + ", Do you want to play again [Y or N]");
      String Y = sc.next();
      if (Y.compareToIgnoreCase("Y") == 0) {
         new GameDriver(this.playerName);
      }
      sc.close();

   }

   private void play() {

      try {

         boolean blackjack = false;
         this.bet = 0;
         this.doubleDownAllowed = true;

         System.out.printf("\nBalance:$%.1f\n", this.balance);
         String msg = "Enter your bet for this game:";

         while (this.bet <= 0) {
            try {
               System.out.println("\n" + msg);
               this.bet = sc.nextFloat();
            } catch (InputMismatchException e) {
               sc.nextLine();
            } finally {
               msg = "Enter your bet in integer value please, greater than zero:";
            }
         }

         if ((this.bet >= 1) && (this.bet % 1 == 0) && (this.balance - this.bet >= 0)) {
            this.balance = this.balance - this.bet;
            // players start with empty hands
            player.emptyHand();
            dealer.emptyHand();

            this.playerDone = false;
            this.dealerDone = false;

            //Initial cards for players
            player.addCardtoHand(deck.dealWithCurrentDeck());
            dealer.addCardtoHand(deck.dealWithCurrentDeck());
            player.addCardtoHand(deck.dealWithCurrentDeck());
            dealer.addCardtoHand(deck.dealWithCurrentDeck());

            // Cards Dealt
            System.out.println("\n--------------- Cards Dealt ---------------\n");
            dealer.printAllCardsInHand();
            player.printAllCardsInHand();

            System.out.printf("Your Score:%d\t", player.playerTotal());
            System.out.printf("Bet:$%.0f\t", this.bet);
            System.out.printf("Balance:$%.1f\n\n", this.balance);

            // checking state on initial card -- if BlackJack
            /*ToDo To-Do */
         } else {
            System.out.printf("Your Balance:$%.1f\n\n", this.balance);
            throw new Exception("Incorrect amount to bet!!");
         }
      } catch (Exception ex) {
         System.out.println(ex.getMessage());
         exit(1);
      }
   }

   public static void main(String[] args) {
      logger.info("\n--------------- BLACK JACK GAME BEGIN-----------------\n");

      Scanner scanner = new Scanner(System.in);
      String playerName;

      System.out.println("Enter Your Name:\n");
      playerName = scanner.nextLine();
      try {
         new GameDriver(playerName);
      } catch (Exception ex) {
         System.out.println(ex.getMessage());
         System.out.println("Aborting the game due to exception" + ex.toString());
         exit(1);
      }
      scanner.close();
      logger.info("\n--------------- BLACK JACK GAME END-----------------\n");
   }
}
