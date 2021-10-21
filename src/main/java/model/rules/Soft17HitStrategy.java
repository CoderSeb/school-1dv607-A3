package model.rules;

import model.Card;
import model.Player;

public class Soft17HitStrategy implements HitStrategy {
  private static final int hitLimit = 17;

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
