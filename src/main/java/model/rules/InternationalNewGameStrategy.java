package model.rules;

import model.Card;
import model.Dealer;
import model.Deck;
import model.Player;


class InternationalNewGameStrategy implements NewGameStrategy {

  public boolean newGame(Deck deck, Dealer dealer, Player player) {
    dealer.giveOpenCard(player);
    dealer.giveOpenCard(dealer);
    dealer.giveOpenCard(player);

    return true;
  }
}