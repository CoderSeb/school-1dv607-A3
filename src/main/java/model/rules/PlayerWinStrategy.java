package model.rules;

public class PlayerWinStrategy implements WinStrategy {
  public boolean equalWinner(int playerScore, int dealerScore, int maxScore) {
    if (playerScore > maxScore) {
      return true;
    } else if (dealerScore > maxScore) {
      return false;
    }
    return dealerScore > playerScore;
  }
}
