package homework07.hangman;

import javax.swing.SwingUtilities;

public class HangmanGame extends GameGUI
        implements GameLogic, TimerLogic {
    private Thread timerThread;

    @Override
    protected void startGame() {
        super.startGame();
        inputField.addActionListener(e -> processInput());
        timerThread = new Thread(() -> {
            try {
                while (!timeEnds()) {
                    Thread.sleep(1000);
                    timeLeft--;
                    SwingUtilities.invokeLater(this::updateDisplay);
                }
                SwingUtilities.invokeLater(() -> endGame(false));
            } catch (InterruptedException ex) {
            }
        });
        timerThread.start();
    }

    @Override
    public void handleGuess(char guess) {
        if (guessedLetters.contains(guess)) {
            System.out.println("That letter has already been guessed. Try another one!");
            return;
        }
        guessedLetters.add(guess);
        if (!currentWord.contains(String.valueOf(guess))) {
            attemptsLeft--;
        }
        updateDisplay();
        if (attemptsLeft == 0 || hasWon()) {
            endGame(hasWon());
        }
    }

    @Override
    public boolean hasWon() {
        for (char c : currentWord.toCharArray()) {
            if (!guessedLetters.contains(c)) return false;
        }
        return true;
    }

    @Override
    public void endGame(boolean won) {
        if (timerThread != null) timerThread.interrupt();
        if (won)
            System.out.println("You won! Word was \"" + currentWord + "\"");
        else
            System.out.println("You lost. Word was \"" + currentWord + "\"");
        inputField.setEnabled(false);
        System.exit(0);
    }

    @Override
    public void startTimer() {
    }

    private boolean timeEnds() {
        return timeLeft <= 0;
    }
}
