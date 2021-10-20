package model.rules;

import java.util.Iterator;
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
    Iterator<Card> it = dealer.getHand().iterator();

    while(it.hasNext()) {
      Card c = it.next();
      if (c.getValue() != Card.Value.Ace) {
        score += cardScores[c.getValue().ordinal()];
      }
    }
    return score != (firstScore - 1);
  }
}
