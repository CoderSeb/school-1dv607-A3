package model.rules;

import model.Card;
import model.Player;

public class Soft17HitStrategy implements HitStrategy {
  private static final int hitLimit = 17;

  public boolean doHit(Player dealer) {
    int score = dealer.calcScore();
    for (Card c : dealer.getHand()) {
      if (c.getValue() == Card.Value.Ace && score <= hitLimit) {
        return true;
      }
    }
    return score < 17;
  }
}
