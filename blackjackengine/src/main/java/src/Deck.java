package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Deck {
   private final static Logger logger = LogManager.getLogger(Deck.class);

   private List<Card> cards = new ArrayList<Card>();//this is the whole deck

   public Deck() throws Exception {
      List<String> _ranks = new ArrayList<String>();
      _ranks.add("Ace");
      _ranks.add("Two");
      _ranks.add("Three");
      _ranks.add("Four");
      _ranks.add("Five");
      _ranks.add("Six");
      _ranks.add("Seven");
      _ranks.add("Eight");
      _ranks.add("Nine");
      _ranks.add("Ten");
      _ranks.add("Jack");
      _ranks.add("Queen");
      _ranks.add("King");

      //ranks of all cards from ace to king
      for (Suits suit : Suits.values()) {
         for (String rank : _ranks) {
            if (rank.contentEquals("Ten") || rank.contentEquals("Jack")
                  || rank.contentEquals("Queen") || rank.contentEquals("King")) {
               cards.add(new Card(10, suit, rank));
            }
            if (rank.contentEquals("Ace")) {
               cards.add(new Card(1, suit, rank));
            }
            if (rank.contentEquals("Two")) {
               cards.add(new Card(2, suit, rank));
            }
            if (rank.contentEquals("Three")) {
               cards.add(new Card(3, suit, rank));
            }
            if (rank.contentEquals("Four")) {
               cards.add(new Card(4, suit, rank));
            }
            if (rank.contentEquals("Five")) {
               cards.add(new Card(5, suit, rank));
            }
            if (rank.contentEquals("Six")) {
               cards.add(new Card(6, suit, rank));
            }
            if (rank.contentEquals("Seven")) {
               cards.add(new Card(7, suit, rank));
            }
            if (rank.contentEquals("Eight")) {
               cards.add(new Card(8, suit, rank));
            }
            if (rank.contentEquals("Nine")) {
               cards.add(new Card(9, suit, rank));
            }
         }
      }
   }

   public List<Card> getCards() {
      return this.cards;
   }

   public void printAllCards() {
      logger.info("********** ALL CARDS BEGIN**********");
      for (Card card : this.cards) {
         logger.info(String.format("[CARD detail] %s %s %s", card.getSuit(), card.getFace(), card.getRank()));
      }
      logger.info("********** ALL CARDS END**********");
   }

   public void setCards(List<Card> cards) {
      this.cards = cards;
   }

   public List<Card> shuffleDeck(List<Card> cards) {
      Collections.shuffle(cards);
      return cards; //shuffled cards/deck
   }

   public Card dealWithCurrentDeck() {
      //return first or last element of list. Delete it too ??
      Card returnThisCard = this.cards.get(0);
      this.cards.remove(0);
      logger.info(String.format("[deal with card] cars to deal is %s", returnThisCard.toString()));
      return returnThisCard;

   }

}
