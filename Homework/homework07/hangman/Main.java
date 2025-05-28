/*
package homework07.hangman;

public class Main {
    public static void main(String args[]) {
        Timer x = new Timer();
    }
}
*/

package homework07.hangman;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(HangmanGame::new);
    }
}


