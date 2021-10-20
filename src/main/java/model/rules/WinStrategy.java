package model.rules;

public interface WinStrategy {
  boolean equalWinner(int playerScore, int dealerScore, int maxScore);
}
