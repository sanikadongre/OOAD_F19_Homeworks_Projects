package src;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Player {
   private final static Logger logger = LogManager.getLogger(Player.class);
   private String player;
   private Hand hand;

   public Player(String player) {
      logger.info(String.format("Creating player for the game with name: %s", player));
      this.player = player;
      hand = new Hand();
      hand.emptyHand();
   }

   public String getPlayer() {
      return player;
   }

   public void setPlayer(String player) {
      this.player = player;
   }

   public Hand currentHand() {
      logger.info(String.format("[Hand object] Representing Current cards in hand... %s", hand.toString()));
      return this.hand;
   }

   public boolean addCardtoHand(Card card) throws Exception {
      return this.hand.addCard(card);
   }

   public void emptyHand() {
      this.hand.emptyHand();
   }

   public void printAllCardsInHand() {
      this.hand.printAllCardsInHand();
   }

   public Integer playerTotal() {
      return this.hand.sumOfTheCards();
   }

   /*
   public void hit() {
      logger.info("");

   }
   public void stand() {
      logger.info("");

   }
   public void doubleDown() {
      logger.info("");

   }
   public void split() {
      logger.info("");

   }
   public void reveal() {
      logger.info("");
   }
   */

}
