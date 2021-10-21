package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;

class AmericanNewGameStrategy implements NewGameStrategy {

  public boolean newGame(Deck deck, Dealer dealer, Player player) {
    dealer.giveOpenCard(player);
    dealer.giveOpenCard(dealer);
    dealer.giveOpenCard(player);
    dealer.giveHiddenCard(dealer);

    return true;
  }
}