package homework07.hangman;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JFrame {
    // GUI components
    protected JLabel wordLabel, attemptsLabel, timeLabel;
    protected JTextField inputField;
    protected String currentWord = "example"; // he word the player has to guess (fixed for now)
    protected ArrayList<Character> guessedLetters = new ArrayList<>(); //Stores the letters guessed by the player
    protected int attemptsLeft = 6;     //Number of tries left
    protected int timeLeft = 60; //Time left (not yet functional – stays at 60)

    // Sets up the window and its components
    public Game() {
        setTitle(" Hangman Game ");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));
        JButton startButton = new JButton(" Start Game "); //Button to start a new game
        add(startButton);
        // Label showing the guessed word with _ for unknown letters
        wordLabel = new JLabel(" Word: ", SwingConstants.CENTER);
        add(wordLabel);
        // Label showing how many tries are left
        attemptsLabel = new JLabel(" Attempts left: " + attemptsLeft,
                SwingConstants.CENTER);
        add(attemptsLabel);
        // Label showing the time left (not yet changing )
        timeLabel = new JLabel(" Time left: " + timeLeft,
                SwingConstants.CENTER);
        add(timeLabel);
        // Input field where the player types their guess
        inputField = new JTextField();
        inputField.setHorizontalAlignment(JTextField.CENTER);
        inputField.setEnabled(false); // initially inactive
        add(inputField);
        inputField.addActionListener(e -> processInput());
        // Starts the game when button is clicked and disables restart
        startButton.addActionListener(e -> {
            startGame();
            startButton.setEnabled(false);
        });
        setVisible(true);
    }

    // Resets game state when starting a new game
    protected void startGame() {
        guessedLetters.clear();
        attemptsLeft = 6;
        timeLeft = 60;
        updateDisplay();
        inputField.setEnabled(true);
        inputField.requestFocus();
    }

    // Updates the word , attempts , and time on the screen
    protected void updateDisplay() {
        StringBuilder display = new StringBuilder();
        for (char c : currentWord.toCharArray()) {
            if (guessedLetters.contains(c)) {
                display.append(c).append(" ");
            } else {
                display.append("_ ");
            }
        }
        wordLabel.setText(" Word: " + display);
        attemptsLabel.setText(" Attempts left: " + attemptsLeft);
        timeLabel.setText(" Time left: " + timeLeft);
    }

    /* TODO Task 1: Add ActionListener for keyboard input on
    inputField and process the input */
    public void processInput() {
        String input = inputField.getText().toLowerCase();
        inputField.setText("");
        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.println("Please enter exactly one letter.");
            return;
        } else {
            handleGuess(input.charAt(0));
        }
    }

    /* TODO Task 1: Check if the guessed letter is in the
    word and handle result */
    protected void handleGuess(char guess) {
        if (guessedLetters.contains(guess)) {
            System.out.println("That letter has already been guessed. Try another one!");
            return;
        }
        guessedLetters.add(guess);
        if (!currentWord.contains(String.valueOf(guess))) {
            attemptsLeft--;
        }
        if (attemptsLeft == 0 || hasWon())
            endGame(hasWon());
        updateDisplay();

    }

    /* TODO Task 1: Check if the player has guessed
    all letters correctly */
    private boolean hasWon() {
        for (int i = 0; i < this.currentWord.length(); i++) {
            boolean dummy = false;
            for (int j = 0; j < this.guessedLetters.size(); j++) {
                if (Character.toLowerCase(currentWord.charAt(i)) == Character.toLowerCase(guessedLetters.get(j))) {
                    dummy = true;
                    break;
                }
            }
            if (!dummy) return false;
        }
        return true;
    }

    //TODO Task 1: End the game and show a message
    protected void endGame(boolean won) {
        if (won) {
            System.out.println("The target word \"" + this.currentWord + "\" has been correctly guessed. Congratulations!");
        } else {
            System.out.println("The target word \"" + this.currentWord + "\" has not been correctly guessed. Better luck next time!");
        }
        inputField.setEnabled(false);
        System.exit(0);
    }
}
