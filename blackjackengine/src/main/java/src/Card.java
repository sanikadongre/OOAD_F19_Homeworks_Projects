package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*

   class: Card
   attributes:
      1. suit: The suit to which the card belongs (category)
      2. rank: The integer value of card. 10s jacks queens kings have integer value 10.
      3. face: The picture value/ category of the card

 */

public class Card {
   private final static Logger logger = LogManager.getLogger(Card.class);

   private Suits suit;
   private int rank;
   private String face; // who is that card - jack, king, queen etc.
   private List<String> _suit = new ArrayList<String>();
   private HashMap<String, Integer> _rank = new HashMap<String, Integer>();

   public Card(Integer rank, Suits suit, String face) throws Exception {
      logger.info(String.format("Creating card with following value %d, suit %s and face %s", rank, suit, face));
      if (rank < 1 || rank > 13) {
         throw new Exception("Card numbers should be between 1 and 13 only.");
      }
      if (rank > 10) { //10, jack, queen, king - all have value of 10.
         rank = 10;
      }
      this.rank = rank;
      this.suit = suit;
      this.face = face;
   }

   public String getFace() {
      return face;
   }

   public void setFace(String face) {
      this.face = face;
   }

   public Suits getSuit() {
      return suit;
   }

   public void setSuit(Suits suit) {
      this.suit = suit;
   }

   public int getRank() {
      return rank;
   }

   public void setRank(int rank) {
      this.rank = rank;
   }

   //ToDo: May not be needed. Since cards will be populated/ created from Deck class.
   public void init_cards(Suits suit) {
      //init suite
      _suit.add(suit.toString());
      //init all ranks of all cards from ace to king
      _rank.put("Ace", 1);
      _rank.put("Two", 2);
      _rank.put("Three", 3);
      _rank.put("Four", 4);
      _rank.put("Five", 5);
      _rank.put("Six", 6);
      _rank.put("Seven", 7);
      _rank.put("Eight", 8);
      _rank.put("Nine", 9);
      _rank.put("Ten", 10);
      _rank.put("Jack", 10);
      _rank.put("Queen", 10);
      _rank.put("King", 10);
   }

}
