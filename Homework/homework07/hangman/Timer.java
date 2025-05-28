package homework07.hangman;

public class Timer extends Game {
    protected Thread timerThread;

    public Timer() {
        super();
    }

    @Override
    protected void startGame() {
        super.startGame();
        timerThread = new Thread(new TimerRunnable(this));
        timerThread.start();
    }

    @Override
    protected void endGame(boolean won) {
        timerThread.interrupt();
        super.endGame(won);
    }

    public void decreaseTime() {
        if (timeLeft > 0) timeLeft--;
    }

    public boolean timeEnds() {
        return timeLeft == 0;
    }
}
