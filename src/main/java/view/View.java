package view;

/**
 * Encapsulates the generic view functionality.
 */
public interface View {

  /**
   * Shows a welcome message.
   */
  void displayWelcomeMessage();

  /**
   * Returns pressed characters from the keyboard.
   *
   * @return the pressed character.
   */
  Action getInput();

  /**
   * Displays a card.
   *
   * @param card The card to display.
   */
  void displayCard(model.Card card);

  /**
   * Displays the cards and score of the player.
   *
   * @param hand  the player's hand.
   * @param score the player's score.
   */
  void displayPlayerHand(Iterable<model.Card> hand, int score);

  /**
   * Displays the cards and score of the dealer.
   *
   * @param hand  the dealer's score.
   * @param score the players's score.
   */
  void displayDealerHand(Iterable<model.Card> hand, int score);

  /**
   * Displays the winner of the game.
   *
   * @param dealerIsWinner True if the dealer is the winner.
   */
  void displayGameOver(boolean dealerIsWinner);

  /**
   * Action enum.
   */
  enum Action {
    /**
     * New game action.
     */
    NEW_GAME,
    /**
     * Hit action.
     */
    HIT,
    /**
     * Stand action.
     */
    STAND,
    /**
     * Quit action.
     */
    QUIT;
  }

  /**
   * Pause.
   */
  void pause();

  /**
   * Display player drawn.
   */
  void displayPlayerDrawn();

  /**
   * Display dealer drawn.
   */
  void displayDealerDrawn();
}