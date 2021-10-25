package controller;

import model.Game;
import view.View;


/**
 * Scenario controller for playing the game.
 */
public class Player implements model.CardObserver {
  private Game model;
  private View view;

  public Player(Game model, View view) {
    this.model = model;
    this.view = view;

    model.addSubscriber(this);
  }

  /**
   * Runs the play use case.
   *
   * @return True as long as the game should continue.
   */
  public boolean play() {
    view.displayWelcomeMessage();

    view.displayDealerHand(model.getDealerHand(), model.getDealerScore());
    view.displayPlayerHand(model.getPlayerHand(), model.getPlayerScore());

    if (model.isGameOver()) {
      view.displayGameOver(model.isDealerWinner());
    }

    View.Action input = view.getInput();

    if (input == View.Action.NEW_GAME) {
      model.newGame();
    } else if (input == View.Action.HIT) {
      model.hit();
    } else if (input == View.Action.STAND) {
      model.stand();
    }

    return input != View.Action.QUIT;
  }

  public void handModified(String player) {
    if (player == "Player") {
      view.displayPlayerDrawn();
      view.displayPlayerHand(model.getPlayerHand(), model.getPlayerScore());
    } else {
      view.displayDealerDrawn();
      view.pause();
      view.displayDealerHand(model.getDealerHand(), model.getDealerScore());
    }
  }
}