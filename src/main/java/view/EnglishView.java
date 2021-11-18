package view;

/**
 * Implements an english console view.
 */
public class EnglishView implements View {

  /**
   * Shows a welcome message.
   */
  public void displayWelcomeMessage() {
    for (int i = 0; i < 2; i++) {
      System.out.print("\n");
    }
    System.out.println("Hello Black Jack World");
    System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
  }

  /**
   * Returns pressed characters from the keyboard.

   * @return the pressed character.
   */
  public Action getInput() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      return convertInput(c);
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return convertInput(0);
    }
  }

  private Action convertInput(int input) {
    System.out.println(input);
    switch (input) {
      case('p'):
        return Action.NEW_GAME;
      case('h'):
        return Action.HIT;
      case('s'):
        return Action.STAND;
      default:
        return Action.QUIT;
    }
  }

  public void displayCard(model.Card card) {
    System.out.println("" + card.getValue() + " of " + card.getColor());
  }

  public void displayPlayerHand(Iterable<model.Card> hand, int score) {
    displayHand("Player", hand, score);
  }

  public void displayDealerHand(Iterable<model.Card> hand, int score) {
    displayHand("Dealer", hand, score);
  }

  private void displayHand(String name, Iterable<model.Card> hand, int score) {
    System.out.println(name + " Has: ");
    for (model.Card c : hand) {
      displayCard(c);
    }
    System.out.println("Score: " + score);
    System.out.println("");
  }

  /**
   * Displays the winner of the game.

   * @param dealerIsWinner True if the dealer is the winner.
   */
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("GameOver: ");
    if (dealerIsWinner) {
      System.out.println("Dealer Won!");
    } else {
      System.out.println("You Won!");
    }
  }

  public void displayDealerDrawn() {
    System.out.println("Dealer draws a new card...");
  }

  public void displayPlayerDrawn() {
    System.out.println("Player draws a new card...");
  }

  /**
   * Pauses the thread for a give amount of milliseconds.
   */
  public void pause() {
    try {
      Thread.sleep(750);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
