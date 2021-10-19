package model.rules;

import model.Card;
import model.Player;

public class Soft17HitStrategy implements HitStrategy {
  private static final int hitLimit = 17;

  public boolean doHit(Player dealer) {
    for (Card c : dealer.getHand()) {
      if (c.getValue() == Card.Value.Ace && dealer.calcScore() <= hitLimit) {
       return true;
      }
    }
    return dealer.calcScore() < 17;
  }
}
