package src;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hand {
   private final static Logger logger = LogManager.getLogger(Hand.class);
   private List<Card> cards = new ArrayList<Card>(10); //all cards in the hand
   private Integer total;//total value of all cards in hand
   private int cardsInHand;

   public int getCardsInHand() {
      this.cardsInHand = this.cards.size();
      return this.cardsInHand;
   }

   public Hand() {
   }

   public Integer getTotal() {
      this.sumOfTheCards();
      return this.total;
   }

   public void emptyHand(){
      this.cards = new ArrayList<Card>(10);
      this.cardsInHand = 0;
   }

   public boolean addCard(Card card) throws Exception { //new card in the hand from deck
      if (this.total == 10) {
         throw new Exception("Cannot have more than 10 cards in the hand during play.");
      }
      cards.add(card);
      return true;
   }

   public Integer sumOfTheCards() { //sum of cards in hand
      int sum = 0;
      for (Card card : this.cards) {
         sum += card.getRank();
      }
      this.total = sum;
      return sum;
   }

   public Card getAndRemoveOneCard(int index) { //fetch the card for playing
      Card returnThisCard = this.cards.get(index);
      this.cards.remove(index);
      return returnThisCard;
   }

   public Card queryOneCard(int index) { //just look at the card
      return this.cards.get(index);
   }

    public void printAllCardsInHand() {
      logger.info("********** ALL CARDS BEGIN**********");
      for (Card card : this.cards) {
         logger.info(String.format("[CARD detail] %s %s %s", card.getSuit(), card.getFace(), card.getRank()));
      }
      logger.info("********** ALL CARDS END**********");
   }

}
