package model;

import model.rules.HitStrategy;
import model.rules.Soft17HitStrategy;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameTests {
  Player d;
  HitStrategy soft17Rule;

  @BeforeEach
  void setUpDealer() {
    soft17Rule = new Soft17HitStrategy();
    d = new Player();
    Card.Mutable ace = new Card.Mutable(Card.Color.Spades, Card.Value.Ace);
    Card.Mutable two = new Card.Mutable(Card.Color.Spades, Card.Value.Two);
    Card.Mutable four = new Card.Mutable(Card.Color.Spades, Card.Value.Four);
    d.dealCard(ace);
    d.dealCard(two);
    d.dealCard(four);
    d.showHand();
  }

  @Test
  @Order(1)
  @DisplayName("Dealer with a soft 17 should take one more card.")
  void soft17TrueToHit() {
    assertTrue(soft17Rule.doHit(d));
  }

  @Test
  @Order(2)
  @DisplayName("Dealer has 17, with a King Dealer should have 17.")
  void soft17Calc() {
    Card.Mutable king = new Card.Mutable(Card.Color.Spades, Card.Value.King);
    d.dealCard(king);
    d.showHand();
    assertEquals(17, d.calcScore());
  }

  @Test
  @Order(3)
  @DisplayName("Dealer has hard 17, gets another Ace, score should be 18.")
  void soft17NewCalc() {
    Card.Mutable ace = new Card.Mutable(Card.Color.Hearts, Card.Value.Ace);
    d.dealCard(ace);
    d.showHand();
    assertEquals(18, d.calcScore());
  }

  @Test
  @Order(4)
  @DisplayName("Dealer has 18, should not take another card.")
  void soft17FalseToHit() {
    Card.Mutable ace = new Card.Mutable(Card.Color.Hearts, Card.Value.Ace);
    d.dealCard(ace);
    d.showHand();
    assertFalse(soft17Rule.doHit(d));
  }
}
