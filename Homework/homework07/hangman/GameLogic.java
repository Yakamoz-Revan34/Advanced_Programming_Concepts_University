package homework07.hangman;

public interface GameLogic {
    void handleGuess(char guess);
    boolean hasWon();
    void endGame(boolean won);
}
