package homework07.hangman;

import javax.swing.*;

public class TimerRunnable implements Runnable {
    private final Timer game;

    public TimerRunnable(Timer game) {
        this.game = game;
    }

    @Override
    public void run() {
        //TODO: Implement the countdown loop
        //Decrease timeLeft every second
        //Update the time label using SwingUtilities . invokeLater ()
        //End the game if time runs out
        try {
            while (!game.timeEnds()) {
                Thread.sleep(1000L);
                game.decreaseTime();
                SwingUtilities.invokeLater(() -> game.updateDisplay());
            }
            SwingUtilities.invokeLater(() -> {game.endGame(false);});
        } catch (Exception e) {
            //404
        }
    }
}
