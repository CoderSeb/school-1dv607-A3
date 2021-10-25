package model;

/**
 * The interface Card observer.
 */
public interface CardObserver {
  /**
   * Method to call when a hand is modified.
   *
   * @param player as a String to describe what player.
   */
  void handModified(String player);
}
