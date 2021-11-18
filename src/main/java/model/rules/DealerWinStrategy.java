package model.rules;

/**
 * The type Dealer win strategy.
 */
public class DealerWinStrategy implements WinStrategy {

  /**
   * Returns true if dealer is winner.
   *
   * @param playerScore as the player score.
   * @param dealerScore as the dealer score.
   * @param maxScore as the maximum score.
   * @return true if dealer is winner.
   */
  public boolean equalWinner(int playerScore, int dealerScore, int maxScore) {
    if (playerScore > maxScore) {
      return true;
    } else if (dealerScore > maxScore) {
      return false;
    }
    return dealerScore >= playerScore;
  }
}
