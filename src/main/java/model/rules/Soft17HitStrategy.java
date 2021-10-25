package model.rules;

import model.Card;
import model.Player;

/**
 * Soft 17 hit strategy class.
 */
public class Soft17HitStrategy implements HitStrategy {
  private static final int hitLimit = 17;

  /**
   * Checks if dealer should take another card based on the given rules.
   *
   * @param dealer as the dealer object.
   * @return true if dealer should take another card.
   */
  public boolean doHit(Player dealer) {
    int score = dealer.calcScore();
    for (Card c : dealer.getHand()) {
      if (c.getValue() == Card.Value.Ace && score == hitLimit) {
        if (isSoft(dealer)) {
          return true;
        }
      }
    }
    return score < 17;
  }

  /**
   * Returns true if dealer hand is soft.
   *
   * @param dealer as the dealer object.
   * @return true if dealer hand is soft.
   */
  private boolean isSoft(Player dealer) {
    int[] cardScores = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };
    int score = 0;
    int firstScore = dealer.calcScore();
    int nrOfAces = 0;
    for (Card c : dealer.getHand()) {
      if (c.getValue() != Card.Value.Ace) {
        score += cardScores[c.getValue().ordinal()];
      } else {
        nrOfAces += 1;
      }
    }

    return score != (firstScore - nrOfAces);
  }
}
