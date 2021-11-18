package model.rules;

/**
 * Interface for the Win Strategy.
 */
public interface WinStrategy {
  /**
   * Returns true if dealer is winner.
   *
   * @param playerScore as the player score.
   * @param dealerScore as the dealer score.
   * @param maxScore as the maximum score.
   * @return true if dealer is winner.
   */
  boolean equalWinner(int playerScore, int dealerScore, int maxScore);
}
